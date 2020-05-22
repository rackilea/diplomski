@Path("oauth")
public class OAuthService {
    @GET
    @Produces("text/html")
    public String secretService(@Context HttpContext httpContext) {
        OAuthServerRequest request = new OAuthServerRequest(httpContext.getRequest());

        OAuthParameters params = new OAuthParameters();
        params.readRequest(request);
        OAuthSecrets secrets = new OAuthSecrets().consumerSecret("secretKey");

        try {
            if(!OAuthSignature.verify(request, params, secrets)) 
                return "false";
        } catch (OAuthSignatureException ose) {
            return "false";
        }

        return "OK";
    }
}