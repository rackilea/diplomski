import javax.servlet.http.HttpServletRequest;

import net.oauth.exception.OAuthException;
import net.oauth.signature.impl.OAuthHmacSha1Signature;
import net.oauth.token.AccessToken;
import net.oauth.token.AuthorizedToken;
import net.oauth.token.RequestToken;

import com.neurologic.oauth.service.impl.OAuth1Service;

/**
 * @author The Elite Gentleman
 * @since 05 December 2010
 *
 */
public class TwitterOAuthService extends OAuth1Service {

    public static final String REQUEST_TOKEN_SESSION = "TWITTER_REQUEST_TOKEN_SESSION";

    /* (non-Javadoc)
     * @see com.neurologic.oauth.service.impl.OAuth1Service#processReceivedAuthorizedToken(javax.servlet.http.HttpServletRequest, net.oauth.token.AuthorizedToken)
     */
    @Override
    protected AccessToken processReceivedAuthorizedToken(HttpServletRequest request, AuthorizedToken authorizedToken) throws OAuthException {
        // TODO Auto-generated method stub
        String requestTokenSecret = null;
        RequestToken requestToken = (RequestToken) request.getSession().getAttribute(REQUEST_TOKEN_SESSION);

        if (requestToken != null) {
            requestTokenSecret = requestToken.getTokenSecret();
        }

        return getConsumer().requestAccessToken(null, authorizedToken, requestTokenSecret, new OAuthHmacSha1Signature());
    }
}