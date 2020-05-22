public class WebServiceFilter implements Filter {

   @Override
   public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException,
         IOException {
      if(/* CONDITION */){

         RequestDispatcher rd = req.getRequestDispatcher("/rest/callUserService");
         rd.forward(req, res);
      }
   }
}