public class BrowserFactor {
    Map<String, Class<? extends Browser> clazz = ...; // I'd use DI, but this could be manually created.
    public Browser create(String type) {
        return clazz.newInstance();
    }
}