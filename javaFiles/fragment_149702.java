public class BackOfficeServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        User u = getUserFromSession(request.getSession(false));
        Action a = getActionFromRequest(request);

        if(UserActionAuthenticator.actionIsAllowed(u, a))
            a.execute(u, request);
    }
}