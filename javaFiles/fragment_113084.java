protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        Action action = ActionFactory.getAction(request);
        String view = action.execute(request, response);

        if (view.equals(request.getPathInfo().substring(1)) {
            request.getRequestDispatcher("/WEB-INF/" + view + ".jsp").forward(request, response);
        } else {
            response.sendRedirect(view);
        }
    } catch (Exception e) {
        throw new ServletException("Executing action failed.", e);
    }
}