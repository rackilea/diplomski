public class RestClient {

    private static Api REST_CLIENT;
    private static String BASE_URL = "base_url";

    public RestClient() {}

    public static Api getInstance() {
        if (REST_CLIENT == null) {
            setupRestClient();

        }
        return REST_CLIENT;
    }


    private static void setupRestClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .build();
            REST_CLIENT = restAdapter.create(Api.class);
        }
    }