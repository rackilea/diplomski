public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    // Start Seam lifecycle
    LifeCycle.beginCall();
    // Get an instance of the authenticator component from Seam
    MyAuthenticator auth = Component.getInstance("myAuthenticator");
    // Set access key in component and perform auth
    auth.setAccessKey(req.getParameter("accessKey"));
    String result = auth.doAuth();
    // End Seam lifecycle, no more component calls are needed.
    LifeCycle.endCall();

    // Do something here with the result
    if ("ok".equals(result)) {
        resp.sendRedirect(...);
    }
}