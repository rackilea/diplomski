public class SecuredRequestBuilderFactory extends DefaultRequestBuilderFactory {

    @Inject
    public SecuredRequestBuilderFactory(HttpRequestBuilderFactory httpRequestBuilderFactory, BodyFactory bodyFactory, HeaderFactory headerFactory, UriFactory uriFactory, @RequestTimeout Integer requestTimeoutMs) {
        super(httpRequestBuilderFactory, bodyFactory, headerFactory, uriFactory, requestTimeoutMs);
    }

    @Override
    public <A extends RestAction<?>> RequestBuilder build(A action, String securityToken) throws ActionException {
        RequestBuilder builder = super.build(action, securityToken);
        builder.setIncludeCredentials(true);
        return builder;
    }
}