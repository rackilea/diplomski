RequestInterceptor requestInterceptor = new RequestInterceptor()
{
    @Override
    public void intercept(RequestFacade request) {
        request.addQueryParam("app_version", "Version 1.x");
        request.addQueryParam("device_type", "Samsung S4");
    }
};

restAdapter.setRequestInterceptor(requestInterceptor)