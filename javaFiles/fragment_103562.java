import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesUtil {

  public static final int COOKIE_DEFAULT_AGE = 30 * 24 * 60 * 60; // 30天
  private static final String COOKIE_DOMAIN = ".domain.com";
  private static final String COOKIE_PATH = "/";

  public static void removeCookie(String cookieName, HttpServletResponse response) {
    removeCookie(cookieName, COOKIE_DOMAIN, COOKIE_PATH, response);
  }

  /**
   * remove cookie
   * @param cookieName
   * @param domain
   * @param response
   */
  private static void removeCookie(String cookieName, String domain,
      String path, HttpServletResponse response) {
    Cookie cookie = new Cookie(cookieName, "");
    cookie.setPath(path);
    cookie.setDomain(domain);
    cookie.setMaxAge(0);
    response.addCookie(cookie);
  }
}