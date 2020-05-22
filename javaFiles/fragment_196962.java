public class JsonConnection{
    private UrlBuilder urlBuilder;

    public JsonConnection(UrlBuilder urlBuilder) {
        this.urlBuilder = urlBuilder;
    }
} 

@Component  
public class FacebookJsonConnection extends JsonConnection {
    private UrlBuilder urlBuilderFacebook;
    @Inject
    public FacebookJsonConnection(UrlBuilder urlBuilderFacebook) {
        super(urlBuilderFacebook);
        this.urlBuilderFacebook = urlBuilderFacebook;
    }
}