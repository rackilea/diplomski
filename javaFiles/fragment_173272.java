public class FlickrAuth extends HttpServlet {
     ...
     //after you get the initial requestToken, save it (e.g. session, database,..)
     Token requestToken = service.getRequestToken();
     request.getSession().setAttribute("some key", requestToken);


  public class FlickrCallback extends HttpServlet {
     ...
     //later you will need that original requestToken
     Token savedRequestToken = request.getSession().getAttribute("some key");
     Verifier verifier = new Verifier(code); //from request param oauth_verifier
     Token accessToken = service.getAccessToken(savedRequestToken, verifier);