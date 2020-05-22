@Configuration
class YourConfig {
    // you usually don't need to explicitly give the bean name
    // if you don't, Spring gives it the config's method name
    @Bean(name = "mglsChecker", destroyMethod = "close") 
    MglsAdapter mglsChecker(@Value("${mgls.server.address}") String address,
                                   @Value("${mgls.fname}") String  fname,
                                   @Value("${mgls.lcount}") long lcount) {
        return new DefaultMglsAdapter(address, fname, lcount);
    }
}