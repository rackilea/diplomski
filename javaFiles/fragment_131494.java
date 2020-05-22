public class StringToPortalBrandingConverter implements Converter<String, PortalBranding> {

    @Inject // or @Autowire
    SomeService someService; // Some service or other dependency you need.

    @Override
    public PortalBranding convert(String source) {
        // Do your conversion from 'source' to 'PortalBranding' here.
        // You can make use of your injected 'someService' as well.
        ...
        return portalBranding;
    }
}