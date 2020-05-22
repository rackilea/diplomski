public class MyResolver implements EntityResolver {
    public InputSource resolveEntity (String publicId, String systemId)
    {
        if (systemId.equals("http://www.apple.com/DTDs/PropertyList-1.0.dtd")) {
            return new InputSource(MyResolver.class.getResourceAsStream("/dtds/PropertyList-1.0.dtd");
        } else {
            // use the default behaviour
            return null;
        }
    }
}