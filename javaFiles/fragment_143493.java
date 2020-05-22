@Bean
    public UrlBasedViewResolver jspResolver(){
        System.out.println("in WebConfig jspResolver");
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setViewClass(JstlView.class);
        urlBasedViewResolver.setPrefix("/");
        urlBasedViewResolver.setSuffix(".jsp");
        return urlBasedViewResolver;
    }