protected void doView(RenderRequest req, RenderResponse resp)
       throws PortletException, IOException, UnavailableException {
   resp.setContentType("text/html"); 
   String myview = req.getParameter("myview");
   String view = "/WEB-INF/jsp/" + (myview==null ? "bar" : myview) + ".jsp";
   PortletRequestDispatcher dispatcher = 
                                 getPortletContext().getRequestDispatcher(view);
   dispatcher.include(req, resp);
}