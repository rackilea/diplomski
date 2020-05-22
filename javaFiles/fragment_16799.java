@Configuration
public class FeignConfig {

@Bean
@ConditionalOnMissingBean
public Retryer feignRetryer() {
    return Retryer.NEVER_RETRY;
}

@Bean
@Scope("prototype")
@ConditionalOnMissingBean
public Feign.Builder feignBuilder(Retryer retryer) {
    return Feign.builder()
            .retryer(retryer)
            .invocationHandlerFactory((target, dispatch) -> new CountingFeignInvocationHandler(target, dispatch));
}

}