public class SingltonRetrofitNew
{
    private static RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());

    private static Gson gson = new GsonBuilder().create();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(rxAdapter)
            .build();

    private static GetModels apiService = retrofit.create(GetModels.class);

    private static BehaviorSubject<ArrayList<Model>> observableModelsList;
    private static Observable<ArrayList<Model>> observable = apiService.getModelsList();
    private static Subscription subscription;

    private SingltonRetrofitNew()
    {
    }

    public static void resetObservable()
    {
        observableModelsList = BehaviorSubject.create();

        if (subscription != null && !subscription.isUnsubscribed())
        {
            subscription.unsubscribe();
        }
        subscription = observable.subscribe(new Subscriber<ArrayList<Model>>()
        {
            @Override
            public void onCompleted()
            {
                //do nothing
            }

            @Override
            public void onError(Throwable e)
            {
                observableModelsList.onError(e);
            }

            @Override
            public void onNext(ArrayList<Model> hotels)
            {
                observableModelsList.onNext(hotels);
            }
        });
    }


    public static Observable<ArrayList<Model>> getModelsObservable()
    {
        if (observableModelsList == null)
        {
            resetObservable();
        }
        return observableModelsList;
    }
}