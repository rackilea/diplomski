@Override
           public void addResourceHandlers(final ResourceHandlerRegistry registry) 
           {

                registry.addResourceHandler("/theme*//**").addResourceLocations("/resources/static/")
                        .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))
                        .resourceChain(false)
                        .addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"))
                        .addTransformer(new CssLinkResourceTransformer());
                registry.addResourceHandler("/css*//**").addResourceLocations("/resources/static/")
                        .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))
                        .resourceChain(false)
                        .addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"))
                        .addTransformer(new CssLinkResourceTransformer());
                registry.addResourceHandler("/js*//**").addResourceLocations("/resources/static/")
                        .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))
                        .resourceChain(false)
                        .addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"))
                        .addTransformer(new CssLinkResourceTransformer());

         @Override
         public void configure(final WebSecurity web) throws Exception {
 web.ignoring().antMatchers("/theme/**").antMatchers("/js/**").antMatchers("/css/**");
            }