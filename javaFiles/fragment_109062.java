public SapronApi() {

    RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(BASE_URL)
            .setRequestInterceptor(request -> request.addHeader("Authorization",SharedPreferencesHelper.getToken()))
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .build();
    mApi = restAdapter.create(Api.class);

}


public SapronApi(Boolean dummy){

    RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(BASE_URL)
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .build();
    mApi = restAdapter.create(Api.class);
}