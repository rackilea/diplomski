CharArrayWrapper responseWrapper = new CharArrayWrapper((HttpServletResponse) response); 
try {
    chain.doFilter(request, responseWrapper);

    String responseString = responseWrapper.toString();

    System.out.println("responseString ********************* " + responseString);

    PrintWriter out = response.getWriter();
    out.write(responseString);

} catch (Exception e) {

    // do whatever is necessary (logging etc.)
}