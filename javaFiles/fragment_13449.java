public void addResourceHandlers(ResourceHandlerRegistry registry) {

    registry.addResourceHandler("/css/**")
     .addResourceLocations("/css/");
    registry.addResourceHandler("/img/**")
     .addResourceLocations("/img/");
    registry.addResourceHandler("/js/**")
     .addResourceLocations("/js/");

}