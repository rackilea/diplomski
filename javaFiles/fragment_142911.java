public final boolean preHandle(HttpServletRequest request)
{
    if (handler instanceof HandlerMethod &&
      ((HandlerMethod)handler).getBean() instanceof LoginController)
    {
      return true;
    }
    ...
}