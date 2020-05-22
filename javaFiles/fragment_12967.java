httpContext.getResponse().setResponse(myResponse)
try {
  httpContext.getResponse().getOutputStream().write(new byte[]{})
} catch (Exception e) {
  // writing of headers failed. 
}