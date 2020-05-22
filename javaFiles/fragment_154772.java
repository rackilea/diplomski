HttpServletResponse wrappedResponse = new HttpServletResponseWrapper(response) {

  public void setStatus(int code) {
    super.setStatus(code);
    if(code == 401) handle401();
  }

  // three similar methods for the other setStatus and the two
  // versions of sendError

  private void handle401() {
    this.addHeader(...);
  }
};

filterChain.doFilter(request, wrappedResponse);