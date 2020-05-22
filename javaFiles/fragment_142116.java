public class AUsage {
    @Autowired
    private A a;

    @Bean
    @ConditionalOnMissingBean
    public A createA() {
        return new AImpl();
    }
}