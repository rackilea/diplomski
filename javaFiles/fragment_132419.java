protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
    HttpSession session = request.getSession(true);
    String sid = session.getId();
    String sslId = (String) request.getAttribute(
                "javax.servlet.request.ssl_session");
    String uri = request.getRequestURI();
    OutputStream out = response.getOutputStream();
    PrintWriter pw = new PrintWriter(out);
    HashMap<String, Object> secrets;
    Object secret = null;
    Object notSecret;
    Date d = new Date();

    notSecret = session.getAttribute("unprotected");
    if (notSecret == null) {
        notSecret = "unprotected: " + d.getTime();
        session.setAttribute("unprotected", notSecret);
    }
    secrets = (HashMap<String, Object>) session.getAttribute("protected");
    if (secrets == null) {
        secrets = new HashMap<String, Object>();
        session.setAttribute("protected", secrets);
    }
    if (sslId != null) {
        if (secrets.containsKey(sslId))
            secret = secrets.get(sslId);
        else {
            secret = "protected: " + d.getTime();
            secrets.put(sslId, secret);
        }
    }
    response.setContentType("text/plain");
    pw.println(MessageFormat.format("URI: {0}", new Object[] { uri }));
    pw.println(MessageFormat.format("SID: {0}", new Object[] { sid }));
    pw.println(MessageFormat.format("SSLID: {0}", new Object[] { sslId }));
    pw.println(MessageFormat.format("Info: {0}", new Object[] { notSecret }));
    pw.println(MessageFormat.format("Secret: {0}", new Object[] { secret }));
    pw.println(MessageFormat.format("Date: {0}", new Object[] { d }));
    pw.close();
}