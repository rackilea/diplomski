public ModelAndView handleRequest( HttpServletRequest request, HttpServletResponse response )
        throws ServletException, IOException {

    System.out.println("I will get called infinitely");
    response.getWriter().print( "Hello World!");
    response.getWriter().flush();
    return null;    
}