@Service
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        try {
            Class<?> clazz = request.getClass();
            if (clazz.isAnnotationPresent(Controller.class)) {
                for (Field field : clazz.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Model.class)) {
                        field.set(request, new ModelMap());
                        break;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            // log("Cannot access model field of controller " + clazz.getSimpleName());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        try {
            Class<?> clazz = request.getClass();
            if (clazz.isAnnotationPresent(Controller.class)) {
                for (Field field : clazz.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Model.class)) {
                        ModelMap model = (ModelMap) field.get(request);
                        if (model != null) {
                            modelAndView.addAllObjects(model);
                        }
                        break;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            // log("Cannot access model field of controller " + clazz.getSimpleName());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}