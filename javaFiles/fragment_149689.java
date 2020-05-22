@Component
public class ExampleInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object handler, 
            ModelAndView modelAndView) throws Exception {

        modelAndView.addObject("object", new Object());
    }

}