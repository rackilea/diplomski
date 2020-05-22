@Configuration
public class ChildConfig extends ParentConfig {

    @Bean
    public ChildBean childBean() {
        return new ChildBean();
    }

}