public class YourHandlerIntercepter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) 

            ApiLog log = ApiLog.build(request, response, handler, null);
            logRepository.save(log);
        }
        return true;
    }
}