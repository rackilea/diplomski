@Component
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView mav)
            throws Exception {
        if (mav != null) {
            SmartUserDetails user = (SmartUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            SmartUser smartUser = user.getSmartUser();
            mav.addObject("smartUser", smartUser);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e)
        throws Exception {

    }
}