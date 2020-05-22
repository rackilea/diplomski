public class SimpleServlet extends HttpServlet {

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

    // do something at the servlet here

    String page = (String) req.getAttribute("page"); // page to be forwarded
                                                        // form servlet to
                                                        // jsp
    if (page == null) {
        page = req.getParameter("page");// page to be forwarded form jsp to
                                        // servlet
    }

    this.forwardIfExists(req, resp, page);

}

protected void forwardIfExists(HttpServletRequest req,
        HttpServletResponse resp, String page) throws ServletException, IOException {

    File pagePath = new File(this.getServletContext().getRealPath(page));

    if ( pagePath.exists() ) {
        req.getRequestDispatcher( page ).forward(req, resp);
    } else {
        throw new IllegalArgumentException(String.format( "The page %s does not exist", page ));
    }

}

}