public class MyInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String method = request.getMethod();
        if("PUT".equals(method) || "POST".equals(method)){
            // do your job
        }

        return super.preHandle(request, response, handler);
    }
}