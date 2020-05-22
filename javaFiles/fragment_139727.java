import com.github.scribejava.apis.GitHubApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.model.Verifier;
import com.github.scribejava.core.oauth.OAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Random;

@Path("/github")
public class GithubResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(GithubResource.class);
    private static final String PROTECTED_RESOURCE_URL = "https://api.github.com/user";
    private static final String API_KEY = "your key";
    private static final String API_SECRET = "your secret";
    private static final String CALL_BACK_URL = "https://localhost:8443/github/callback/";
    private static final Token EMPTY_TOKEN = null;

    @GET
    public Response getToken() {
        OAuthService service = createService().build();

        final String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);

        return Response.seeOther(URI.create(authorizationUrl)).build();
    }

    @GET
    @Path("callback")
    @Produces(MediaType.TEXT_PLAIN)
    public Response callback(@QueryParam("code") String oauthToken) {

        OAuthService service = createService().build();

        final Verifier verifier = new Verifier(oauthToken);

        final Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
        final OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL, service);
        service.signRequest(accessToken, request);

        final com.github.scribejava.core.model.Response response = request.send();

        LOGGER.info("Response code: " + response.getCode());
        LOGGER.info("Response body: " + response.getBody());

        return Response.ok(response.getBody()).build();
    }

    private ServiceBuilder createService() {
        return new ServiceBuilder()
            .provider(GitHubApi.class)
            .apiKey(API_KEY)
            .apiSecret(API_SECRET)
            .scope("repo")
            .state("secret" + new Random().nextInt(999_999))
            .callback(CALL_BACK_URL);
    }
}