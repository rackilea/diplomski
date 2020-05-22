@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

       // Register resource handler for CSS and JS
       registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/")
            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic())
            .resourceChain(true)
            .addResolver(new PathResourceResolver());

       // Register resource handler for images
       registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic())
            .resourceChain(true)
            .addResolver(new PathResourceResolver());
       registry.setOrder(-1);  // This will set the priority lower to the default handler (that is by default 0)
    }