protected void beforeRequest(final HttpServletRequest request, final String message) {
  final Principal principal = request.getUserPrincipal();
  final String username = principal != null ? principal.getName() : null;
  if (username != null) {
    MDC.put(USER, username);
  }
}
protected void afterRequest(final HttpServletRequest request, final String message) {
  MDC.remove(USER);
}