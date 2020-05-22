@Bean
public ExampleInterceptor exampleInterceptor() {
   return new ExampleInterceptor();
}

@Override
public void addInterceptors(InterceptorRegistry registry) {                
   registry.addInterceptor(exampleInterceptor()).addPathPatterns("/*");
}