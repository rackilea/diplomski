public class TestInternet implements SOService.TestInternet {
    //TIMEOUT EN MILISEGUNDOS
    private final int MILISECONDS = 3000;

    @Override
    //returns the observable with connection/no connection
    public Observable <Boolean> getObservableConnection(String filter) {  
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                try {
                    URL myUrl = new URL("http://flickr.com");
                    URLConnection connection = myUrl.openConnection();
                    connection.setConnectTimeout(MILISECONDS);
                    connection.connect();

                    emitter.onNext(true);

                } catch (Exception e) {
                    //I'm catching NetworkInMainThreadException here
                    e.printStackTrace();
                    emitter.onNext(false);
                    Log.d("error en testinternet", e.toString());
                }
            }
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()); 

    }