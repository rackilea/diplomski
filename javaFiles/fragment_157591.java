public class MyAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {

  public int division;

  public String execute() {

    // Load from cookie
    for(Cookie c : servletRequest.getCookies()) {
      if (c.getName().equals("cookieDivision"))
        division=Integer.parseInt(c.getValue());
    }

    // Save to cookie
    Cookie div = new Cookie("cookieDivision", String.format("%d",division));
    div.setMaxAge(60*60*24*365); // Make the cookie last a year
    servletResponse.addCookie(div);

    return "success";
  }

  // For access to the raw servlet request / response, eg for cookies
  protected HttpServletResponse servletResponse;
  @Override
  public void setServletResponse(HttpServletResponse servletResponse) {
    this.servletResponse = servletResponse;
  }

  protected HttpServletRequest servletRequest;
  @Override
  public void setServletRequest(HttpServletRequest servletRequest) {
    this.servletRequest = servletRequest;
  }
}