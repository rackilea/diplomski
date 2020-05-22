public class DataClient implements Client {

    private ExecutorService executor = Executors.newFixedThreadPool(10);
    private RestTemplate restTemplate;
    private void initRestClient(DataKey key){
    if(restTemplate == null)
        restTemplate = new RestTemplate(clientHttpRequestFactory(key));
    }

    private ClientHttpRequestFactory clientHttpRequestFactory(DataKey key) {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(key.getTimeout());
        factory.setConnectTimeout(key.getTimeout());
        //if you need to set otherparams this is the place we can do it extracting from DataKey obj
        return factory;
    }

    // for synchronous call
    @Override
    public DataResponse executeSynchronous(DataKey key) {
        initRestClient(key);
        DataResponse dataResponse = new HTTPAccess(key).performRequest();
        return dataResponse;
    }

    //for asynchronous call
    @Override
    public Future<DataResponse> executeAsynchronous(final DataKey key) {
        return executor.submit(new Callable<DataResponse>() {
            @Override
            public DataResponse call() throws Exception {
                return executeSynchronous(key);
            }
        });
    }
}