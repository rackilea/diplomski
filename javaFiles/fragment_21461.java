public void doFilter(ServletRequest servletRequest,ServletResponse servletResponse,
      FilterChain filterChain)
    throws java.io.IOException, javax.servlet.ServletException
{
   HttpServletRequest request = (HttpServletRequest) servletRequest;
   HttpServletResponse response = (HttpServletResponse) servletResponse;
   String currentURL = request.getRequestURI();
   MaintenanceService maintenanceMode = new MaintenanceService();
   if (!currentURL.equals("/maintenance.jsp") 
            && maintenanceMode.getMaintenanceMode())
   {
    String urlNew = currentURL.concat("maintenance.jsp");
    response.sendRedirect(urlNew);
   }
   filterChain.doFilter(servletRequest, servletResponse);
}