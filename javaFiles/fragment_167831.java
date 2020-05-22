public class CrossSubdomainSessionValve extends ValveBase {
  public CrossSubdomainSessionValve() {
    super();
    info = "common-tomcat-CrossSubdomainSessionValve";
  }

  @Override
  public void invoke(Request request, Response response) throws IOException, ServletException {
    // cookie will only need to be changed, if this session is created by this request.
    if (request.getSession(true).isNew()) {
      Cookie sessionCookie = findSessionCookie(response.getCookies());
      if (sessionCookie != null) {
        String cookieDomainToSet = getCookieDomainToSet(request.getServerName());
        if (cookieDomainToSet != null) {
          // changing the cookie only does not help, because tomcat immediately sets
          // a string representation of this cookie as MimeHeader, thus we also
          // have to change this representation
          replaceCookie(response.getCoyoteResponse().getMimeHeaders(), sessionCookie, cookieDomainToSet);
        }
      }
    }

    // process the next valve
    getNext().invoke(request, response);
  }

  protected Cookie findSessionCookie(Cookie[] cookies) {
    if (cookies != null)
      for (Cookie cookie : cookies)
        if (Globals.SESSION_COOKIE_NAME.equals(cookie.getName())) {
          return cookie;
    return null;
  }

  protected void replaceCookie(MimeHeaders headers, Cookie originalCookie, String domainToSet) {
    // if the response has already been committed, our replacementstrategy will have no effect

    // find the Set-Cookie header for the existing cookie and replace its value with new cookie
    for (int i = 0, size = headers.size(); i < size; i++) {
      if (headers.getName(i).equals("Set-Cookie")) {
        MessageBytes value = headers.getValue(i);
        if (value.indexOf(originalCookie.getName()) >= 0) {
          if (originalCookie.getDomain() == null) {
            StringBuilder builder = new StringBuilder(value.getString()).append("; Domain=").append(domainToSet);
            value.setString(builder.toString());
          } else {
            String newDomain = value.getString().replaceAll("Domain=[A-Za-z0-9.-]*", "Domain=" + domainToSet);
            value.setString(newDomain);
          }
        }
      }
    }
  }

  protected String getCookieDomainToSet(String cookieDomain) {
    String[] parts = cookieDomain.split("\\.");
    if (parts.length >= 3) {
      return "." + parts[parts.length - 2] + "." + parts[parts.length - 1];
    }
    return null;
  }

  public String toString() {
    return ("CrossSubdomainSessionValve[container=" + container.getName() + ']');
  }
}