@Configuration
public class ConcurrencyConfig {

    @PostConstruct
    public void init(){
        ConcurrencyUtil.init();
    }

    @PreDestroy
    public void destroy(){
        ConcurrencyUtil.destroy();
    }
}