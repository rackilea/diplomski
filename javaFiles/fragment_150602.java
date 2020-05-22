import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.protocol.HttpContext;

class EasySpecProvider implements CookieSpecProvider {
    @Override
    public CookieSpec create(HttpContext context) {
        return new EasyCookieSpec();
    }
}