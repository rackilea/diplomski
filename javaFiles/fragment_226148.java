public class CommonViewAttributesInterceptor extends HandlerInterceptorAdapter {

    private static final String PROPERTIES_ATTR = "properties";

    private Properties properties = new Properties();

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView) throws Exception {
        request.setAttribute(PROPERTIES_ATTR, properties);
    }

    public void setPropertiesSource(Resource resource) throws IOException {
        InputStream input = resource.getInputStream();
        try {
            properties.load(input);
        } finally {
            input.close();
        }
    }

}