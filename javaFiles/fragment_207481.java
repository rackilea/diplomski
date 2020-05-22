public interface RestApiProvider {
    public <T> T getRestClient(Class<T> clazz);
}

public class RestApiProviderImpl implements RestApiProvider {
    private Map<String, Object> restInstances = new HashMap<String, Object>();
    private RestAdapter restAdapter;

    @Inject
    RestApiProvider(RestAdapter restAdapter) {
        this.restAdapter = restAdapter;
    }

    public <T> T getRestClient(Class<T> clazz) {
        T client = null;

        if ((client = (T) restInstances.get(clazz.getCanonicalName())) != null) {
            return client;
        }

        client = restAdapter.create(clazz);
        restInstances.put(clazz.getCanonicalName(), client);
        return client;
    }

}