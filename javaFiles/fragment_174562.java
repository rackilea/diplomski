class GeneralUtil {

    ThreadLocal<Client> client = new ThreadLocal<Client>() {
        @Override
        public Client initialValue() {
            return ClientBuilder.newClient();
        }
    };

    public static String makeCall(String url) throws NotFoundException {
        return client.get().target(url).request().get(String.class);
    }

    ...
}