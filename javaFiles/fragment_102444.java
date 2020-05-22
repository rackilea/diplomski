@Configuration
public MyConfiguration {

    @Bean
    public Bean1 bean1() {
        return new Bean1(bean2());
    }

    @Bean
    public Bean2 bean2() {
        return new Bean2();
    }
}