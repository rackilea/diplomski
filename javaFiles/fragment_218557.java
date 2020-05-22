public class CacheClearingHandlerInterceptor extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    if("Y".equals(request.getParameter("clearCache"))) {
      doCoolStuff();
    }

    return super.preHandle(request, response, handler);
  }

}