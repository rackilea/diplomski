public class SupportedLocaleAwareLocaleChangeInterceptor extends LocaleChangeInterceptor {

    private List<String>supportedLocales = Arrays.asList("pl",....);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws ServletException {

        String newLocale = request.getParameter(this.paramName);
        //if (newLocale != null) {
        if (newLocale != null && supportedLocales.contains(newLocale )) {
            LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
            if (localeResolver == null) {
                throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
            }
            localeResolver.setLocale(request, response, StringUtils.parseLocaleString(newLocale));
        }
        // Proceed in any case.
        return true;
    } 
}