public class FBAuthServlet extends HttpServlet {

private static final Logger log = Logger.getLogger(FBAuthServlet.class);

private static final long serialVersionUID = 1L;

private UserService userService = //here goes your user service implementation

public FBAuthServlet() {
    super();
}

public void destroy() {
    super.destroy(); // Just puts "destroy" string in log
    // Put your code here
}

public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    if ("y".equals(request.getParameter("FacebookLogin"))) {
        response.sendRedirect(FaceBookConfig.getLoginRedirectURL());
        return;
    }
    String code = req.getParameter("code");
    if (StringUtil.isNotBlankStr(code)) {
        String authURL = FaceBookConfig.getAuthURL(code);
        URL url = new URL(authURL);
        try {
            String result = readURL(url);
            String accessToken = null;
            Integer expires = null;
            String[] pairs = result.split("&");
            for (String pair : pairs) {
                String[] kv = pair.split("=");
                if (kv.length != 2) {
                    res.sendRedirect(FaceBookConfig.MAINURL);
                } else {
                    if (kv[0].equals("access_token")) {
                        accessToken = kv[1];
                    }
                    if (kv[0].equals("expires")) {
                        expires = Integer.valueOf(kv[1]);
                    }
                }
            }

            if (accessToken != null && expires != null) {

                User user = authFacebookLogin(accessToken, request.getRemoteAddr());
                if (user != null && user.getFacebookId() != null) {
                    //forward to spring security filter chain
                    res.sendRedirect(FaceBookConfig.MAINURL + "/j_spring_security_check?j_username=" + user.getEmail() + "&FaceBookId=" + user.getFacebookId());
                } else if (user != null && StringUtil.isNullOrBlank(user.getFacebookId())) {
                    res.sendRedirect(FaceBookConfig.MAINURL + "/login.html?login_error=You are not Registered By Facebook Connect");

                } else {
                    res.sendRedirect(FaceBookConfig.MAINURL);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect(FaceBookConfig.MAINURL);
        }
    }

}

public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    doGet(request, response);
}

public void init() throws ServletException {
}

private String readURL(URL url) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    InputStream is = url.openStream();
    int r;
    while ((r = is.read()) != -1) {
        baos.write(r);
    }
    return new String(baos.toByteArray());
}


private User authFacebookLogin(String accessToken, String ip) {
    try {
        String content = IOUtil.urlToString(new URL("https://graph.facebook.com/me?access_token=" + accessToken));

        JSONObject resp = new JSONObject(content);
        String facebookid = resp.getString("id");
        String firstName = resp.getString("first_name");
        String lastName = resp.getString("last_name");
        String email = resp.getString("email");

        log.info("Facebook response: " + content);

        CreateUserRequestCommand comm = new CreateUserRequestCommand();

        comm.setEmail(email);
        comm.setFacebookId(facebookid);
        comm.setFirst(StringAndDateUtils.safeChar(firstName));
        comm.setLast(StringAndDateUtils.safeChar(lastName));
        //if success login
        if (userService.getUserByEmail(email) == null) {
            //if first time login
            User u = userService.createUser(comm, ip);
            return u;
        } else {//if existed
            User existedUser = userService.getUserByEmail(email);
            return existedUser;

        }
    } catch (Throwable ex) {
        ex.printStackTrace();
    }

    return null;
}
}