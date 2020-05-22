RestAdapter restAdapter = new RestAdapter.Builder()
        .setEndpoint(API_END_POINT)
        .setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addQueryParam("api_eky", API_KEY);
            }
        })
        .build();