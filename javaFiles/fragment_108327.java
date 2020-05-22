import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.oauth.enums.GrantType;
import net.oauth.exception.OAuthException;
import net.oauth.parameters.OAuth2Parameters;

import com.neurologic.oauth.service.impl.OAuth2Service;
import com.neurologic.oauth.util.Globals;

/**
 * @author The Elite Gentleman
 * @since 05 December 2010
 *
 */
public class FacebookOAuthService extends OAuth2Service {

 private static final String REDIRECT_URL = "http://localhost:8080/Music4Point0/oauth/oauth_redirect";

 /* (non-Javadoc)
  * @see com.neurologic.oauth.service.impl.OAuth2Service#processReceivedAuthorization(javax.servlet.http.HttpServletRequest, java.lang.String, java.util.Map)
  */
 @Override
 protected String processReceivedAuthorization(HttpServletRequest request, String code, Map<String, String> additionalParameters) throws OAuthException {
  // TODO Auto-generated method stub
  OAuth2Parameters parameters = new OAuth2Parameters();
  parameters.setCode(code);
  parameters.setRedirectUri(REDIRECT_URL);

  Map<String, String> responseMap = getConsumer().requestAcessToken(GrantType.AUTHORIZATION_CODE, parameters, null, (String[])null);
  if (responseMap == null) {
   //This usually should never been thrown, but we just do anyway....
   throw new OAuthException("No OAuth response retrieved.");
  }

  if (responseMap.containsKey("error")) {
   throwOAuthErrorException(responseMap);
  }

  if (responseMap.containsKey(OAuth2Parameters.ACCESS_TOKEN)) {
   String accessToken = responseMap.remove(OAuth2Parameters.ACCESS_TOKEN);
   request.getSession().setAttribute(Globals.SESSION_OAUTH2_ACCESS_TOKEN, accessToken);
   processAdditionalReceivedAccessTokenParameters(request, responseMap);
  }

  return null;
 }

 /* (non-Javadoc)
  * @see com.neurologic.oauth.service.impl.OAuth2Service#processAdditionalReceivedAccessTokenParameters(javax.servlet.http.HttpServletRequest, java.util.Map)
  */
 @Override
 protected void processAdditionalReceivedAccessTokenParameters(HttpServletRequest request, Map<String, String> additionalParameters) throws OAuthException {
  // TODO Auto-generated method stub

 }
}