import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.impl.cookie.DefaultCookieSpec;

class EasyCookieSpec extends DefaultCookieSpec {
    @Override
    public void validate(Cookie arg0, CookieOrigin arg1) throws MalformedCookieException {
    }
}