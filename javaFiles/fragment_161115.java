@Retention(RetentionPolicy.RUNTIME)
public @interface BackEndApiInterface {
}

@BackEndApiInterface 
@RequestMapping("/resource1")
public interface Api {
    @RequestMapping(method = RequestMethod.POST)
    Resource1 getResource1();
}

@RestController
public class Controller implements Api {
    @Override
    public Resource1 getResource1() {
        return null;
    }
}

@Configuration
public class Config {
    @Bean
    public Api api() {
         return RestClientFactory.createRestClientBasedOnAnnotations(Api.class);
    }

    @Bean
    public static RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return new RequestMappingHandlerMapping() {
            @Override
            protected boolean isHandler(Class<?> beanType) {
                if (AnnotationUtils.findAnnotation(beanType, BackEndApiInterface.class) != null) {
                    return false;
                }
                return super.isHandler(beanType);
            }
        };
    }
}