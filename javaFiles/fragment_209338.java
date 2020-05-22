@RequestMapping(value = "/logout", method = GET)
  @ResponseStatus(value = HttpStatus.OK)
  public void logout(HttpServletRequest request)
  {
    HttpSession session = request.getSession(false);
    if (session != null) {
      session.invalidate();
    }
  }