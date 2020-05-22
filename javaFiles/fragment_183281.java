@Override // needed for jsp resolving
    public void configureViewResolvers(final ViewResolverRegistry registry) {    
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setPrettyPrint(true);      
        registry.enableContentNegotiation(view);        
        registry.jsp("/WEB-INF/views/html/",".jsp");
    }