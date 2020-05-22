@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler(
            "/webjars/**",
            "/img/**",
            "/css/**",
            "/js/**")
            .addResourceLocations(
                    "classpath:/META-INF/resources/webjars/",
                    "classpath:/WEB-INF/img/",
                    "classpath:/WEB-INF/css/",
                    "classpath:/WEB-INF/js/");
}