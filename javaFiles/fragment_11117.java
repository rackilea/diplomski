@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

    switch (req.getServletPath()) {
    case "/increment":
        incrementProduct(req.getParameter("name"));
        break;
    }
}