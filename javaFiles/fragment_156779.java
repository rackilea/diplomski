@Configuration
public class ProxyFactoryBeanConfiguration{

    @Autowired
    private pl.spring.demo.class.impl.AnyClassImpl anyClassImpl;

    @Autowired
    private List<String> interceptorNames;

    @Bean
    public org.springframework.aop.framework.ProxyFactoryBean anyClass(){
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(anyClassImpl);
        proxyFactoryBean.setInterceptorNames(interceptorNames);
        return proxyFactoryBean;
    }

}