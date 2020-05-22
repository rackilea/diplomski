public class UrlBuilder {
    private final String root;
    private int myParam1;
    private String myParam2;

    public UrlBuilder(final String root) {
        this.root = root;
    }

    public UrlBuilder myParam1(int myParam1) {
        this.myParam1 = myParam1;
        return this;
    }

    public UrlBuilder myParam2(String myParam2) {
        this.myParam2 = myParam2;
        return this;
    }

    public URL build() throws MalformedURLException {
        return new URL(
            String.format("%s/%d/%s", root, myParam1, myParam2)
        );
    }
}