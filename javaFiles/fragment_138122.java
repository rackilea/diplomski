public class CheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        if (handler instanceof TheController) {
        // or for any controller: if (handler.getClass().isAnnotationPresent(Controller.class))
            if (!check()) {
                redirect("/check-failure.html");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException {
        try {
            response.sendRedirect(request.getContextPath() + path);
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    private boolean check() {
        return ...
    }

}