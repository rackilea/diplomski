@Override
public void init() throws ServletException {
    String foo = getInitParameter("foo");
    String bar = getServletContext().getInitParameter("bar");
    // ...
}