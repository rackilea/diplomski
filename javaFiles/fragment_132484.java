@Bean
public AspectSecurity interceptor() {
    AspectSecurity aspect = Aspects.aspectOf(AspectSecurity.class);
    // ... inject dependencies here if not using @Autowired
    return aspect;
}