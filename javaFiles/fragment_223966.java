public class MyInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();

        if(uri.contains("/add")){
            // do your job
        }

        return super.preHandle(request, response, handler);
    }
}