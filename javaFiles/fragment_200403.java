public class PreloadModelInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, 
                       HttpServletResponse response, 
                       Object handler,
        ModelAndView modelAndView) throws Exception {
    // add model attibutes for your view to see but not your controller
    }
}