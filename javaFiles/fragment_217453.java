public class CallbackServlet extends HttpServlet {

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    processRequest(req, resp);
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    processRequest(req, resp);
}

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    HttpSession session = request.getSession(true);
    String clientID =(String)session.getAttribute("client_id");
    String clientSecret =(String)session.getAttribute("client_secret");
    String redirectURI =(String)session.getAttribute("redirect_uri");  
    String code = request.getParameter("code");


    JSONObject profile = getTokenContent(clientID, clientSecret, redirectURI, code); 
 }

 public JSONObject getTokenContent(String clientID, String clientSecret, String redirectURI, String code){
    try {

        String httpurl = "https://api.instagram.com/oauth/access_token?"
                + "client_id=" + clientID
                + "&client_secret=" + clientSecret
                + "&grant_type=authorization_code"
                + "&redirect_uri=" + redirectURI
                + "&code="+code;

        URL url = new URL(httpurl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");

        String urlParameters = "client_id=" + clientID
                + "&client_secret=" + clientSecret
                + "&grant_type=authorization_code"
                + "&redirect_uri=" + redirectURI
                + "&code="+code;

        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));

        conn.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream ());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(
                conn.getInputStream()));

        return getJSONFromBufferRd(in);
  }
  }