super.doFilter(request, response, filterChain);
HttpSession session = request.getSession(false);
if (session != null) {
    IFlash flash = new Flash(session);
    flash.recycle();
}