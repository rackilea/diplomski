public class FragmentsList extends Fragment
{
    private static final String TAG = FragmentList.class.getSimpleName();
    private Subscription subscription;
    private RecyclerView recyclerView;
    private ArrayList<Hotel> models = new ArrayList<>();
    private boolean isLoading;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment, container, false);
        //init views
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler);
        if (savedInstanceState != null)
        {
            models = savedInstanceState.getParcelableArrayList(Const.KEY_MODELS);
            isLoading = savedInstanceState.getBoolean(Const.KEY_IS_LOADING);
        }

        if (models.size() == 0 || isLoading)
        {
            getModelsList();
        }
        //TODO show saved data if is

        return v;
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if (subscription != null && !subscription.isUnsubscribed())
        {
            subscription.unsubscribe();
        }
    }

    private void getModelsList()
    {
        if (subscription != null && !subscription.isUnsubscribed())
        {
            subscription.unsubscribe();
        }
        subscription = SingltonRetrofitNew.getModelsObservable().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Subscriber<ArrayList<Hotel>>()
                {
                    @Override
                    public void onCompleted()
                    {
                        Log.d(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        Log.d(TAG, "onError", e);
                        Snackbar.make(recyclerView, R.string.connection_error, Snackbar.LENGTH_SHORT)
                                .setAction(R.string.try_again, new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v)
                                    {
                                        SingltonRetrofitNew.reset();
                                        getModelsList();
                                    }
                                })
                                .show();
                    }

                    @Override
                    public void onNext(ArrayList<Hotel> newModels)
                    {
                        models.clear();
                        models.addAll(newModels);
                        //TODO show data
                    }
                });
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(Const.KEY_MODELS, models);
        outState.putBoolean(Const.KEY_IS_LOADING, isLoading);
    }
}