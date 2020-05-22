doFilter(chain, req, res) {

   ServletRequest wrappedRequest = ...
   ServletResponse wrappedResponse = ...   

   chain.doFilter(wrappedRequest, wrappedResponse);

}