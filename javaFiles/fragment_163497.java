public interface AsyncHandlerInterceptor extends HandlerInterceptor {

    void afterConcurrentHandlingStarted(
            HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception;

}