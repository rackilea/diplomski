public class LocaleSettingAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Resource
    private LocaleResolver localeResolver;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        setLocale(authentication, request, response);
        super.onAuthenticationSuccess(request, response, authentication);
    }

    protected void setLocale(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof LocaleProvider) {
                LocaleProvider localeProvider = (LocaleProvider) principal;
                Locale providedLocale = localeProvider.getLocale();
                localeResolver.setLocale(request, response, providedLocale);
            }
        }
    }
}