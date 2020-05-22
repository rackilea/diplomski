// notice there is no annotation here
public class ParentConfig {

    @Bean
    public ParentBean parentBean() {
        return new ParentBean();
    }

}