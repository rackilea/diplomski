public void addInterceptors(InterceptorRegistry registry) {
    ...        
    registry.addInterceptor(rootDomainInterceptor())
            .excludePathPatterns("/js/**", "/css/**", "/images/**", "/webjars/**");

}