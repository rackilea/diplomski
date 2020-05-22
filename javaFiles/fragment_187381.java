import com.google.api.server.spi.Constant;
import com.google.api.server.spi.auth.GoogleOAuth2Authenticator;

@Api(
  name = "example",
  version = "v1",
  scopes = { Constant.API_EMAIL_SCOPE },
  clientIds = { Constant.SKIP_CLIENT_ID_CHECK },
  authenticators = { ClientIdAuthenticator.class,GoogleOAuth2Authenticator.class }
)