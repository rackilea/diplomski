public void doFilter(..) {
  try {
      chain.doFilter(req, resp);
   } catch (Exception ex) {
       // do something
   }
}