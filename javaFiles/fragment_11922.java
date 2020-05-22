public class FBEnableServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

private UserService userService = (UserService) ServiceLocator.getContext().getBean("userService");

public FBEnableServlet() {
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

    if ("y".equals(request.getParameter("EnableFacebookConnect"))) {
        response.sendRedirect(FaceBookConfig.getEnableRedirectURL());
        return;
    }
    String code = req.getParameter("code");
    if (StringUtil.isNotBlankStr(code)) {
        String authURL = FaceBookConfig.getEnableAuthURL(code);
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
                String loginedEmail = "";
                try {
                    loginedEmail = SecurityContextHolder.getContext().getAuthentication().getName();
                } catch (Exception ex) {

                }
                System.out.println("Logined email = " + loginedEmail);
                System.out.println("Facebook Login email = " + user.getEmail());
                if (user != null && user.getFacebookId() != null && user.getEmail().equals(loginedEmail)) {
                    userService.setFaceBookid(user.getFacebookId());
                    //forward to spring security filter chain
                    res.sendRedirect(FaceBookConfig.MAINURL + "/j_spring_security_check?j_username=" + user.getEmail() + "&FaceBookId=" + user.getFacebookId());
                } else {
                    res.sendRedirect(FaceBookConfig.MAINURL + "/secure/myAccount.html?message=Please login Facebook with same Email,you Login with " + user.getEmail());
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
        String email = resp.getString("email");

        User existedUser = userService.getUserByEmail(email);
        if (existedUser == null) {
            return null;
        } else {
            existedUser.setFacebookId(facebookid);
            return existedUser;
        }


    } catch (Throwable ex) {
        ex.printStackTrace();
    }

    return null;
}
}