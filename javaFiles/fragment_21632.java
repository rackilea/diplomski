@Configuration
public class AppConfig implements WebMvcConfigurer {
   @Bean
   public AcceptHeaderLocaleResolver localeResolver(WebMvcProperties mvcProperties) {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver() {
        @Override
        public Locale resolveLocale(HttpServletRequest request) {
            String locale = request.getParameter("lang");
            return locale != null
                    ? org.springframework.util.StringUtils.parseLocaleString(locale)
                    : super.resolveLocale(request);
        }
        };

        localeResolver.setDefaultLocale(mvcProperties.getLocale());
        return localeResolver;
    }
}