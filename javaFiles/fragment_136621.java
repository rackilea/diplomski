public class URLConverter extends DozerConverter<URL, URL> {

    public URLConverter() {
        super(URL.class, URL.class);
    }

    @Override
    public URL convertTo(URL source, URL destination) {
        URL result = null;
        try {
            result = source.toURI().toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            throw e;
        }

        return result;
    }

    @Override
    public URL convertFrom(URL source, URL destination) {
        URL result = null;
        try {
            result = source.toURI().toURL();
        } catch (MalformedURLException | URISyntaxException e) {
           throw e;
        }

        return result;
    }
}