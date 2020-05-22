@Configuration
public class FullConfig {

    @Bean
    public ParentBean parentBean() {
        return new ParentBean();
    }

    @Bean
    public ChildBean childBean() {
        return new ChildBean();
    }

}