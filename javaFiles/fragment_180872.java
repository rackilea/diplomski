public class MyAction extends ActionSupport implements CookieProvider {

    @Override
    public Set<Cookie> getCookies(){
      Set<Cookie> cookies = new HashSet<>();
      Cookie name = new Cookie("name", userInfo.getName() );
      name.setMaxAge(60*60*24*365); // Make the cookie last a year!
      name.setPath("/"); //Make it at root.
      cookies.add(name);
      return cookies;
    }

}