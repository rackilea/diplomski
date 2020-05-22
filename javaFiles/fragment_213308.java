class RestClientFactory {
    public static IRestClient defaultRestClient() {
        return new RestClient();
    }
    public static IRestClient createRestClient(String name) {
        String realName = name.toLowerCase();
        switch(realName) {
            case "foo":
                return new FooRestClient();
            case "bar":
                return new BarRestClient();
            //and on...
            default:
                return defaultRestClient();
        }
    }
}