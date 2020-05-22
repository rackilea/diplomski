public class XsdUtils {
    static {
        System.setProperty("java.protocol.handler.pkgs", "org.fao.oek.protocols");
    }

    private static XMLCatalogResolver cr;

    public static synchronized XMLCatalogResolver getResolver() {
        if (cr == null) {
            cr = new XMLCatalogResolver(new String[] { "classpath:xml-catalog.xml" });
        }
        return cr;
    }

    public static void main(String[] args) throws MalformedURLException, IOException {
        XMLCatalogResolver resolver = getResolver();
        URL url0 = new URL("classpath:xml-catalog.xml");
        URL url1 = new URL(resolver.resolveURI("http://www.loc.gov/mods/v3"));
        url0.openConnection();
        url1.openConnection();
    }
}