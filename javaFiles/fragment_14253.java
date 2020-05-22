public class SampleModule extends AbstractModule {
     @Override
     protected void configure() {
         SampleInterceptor interceptor = new SampleInterceptor();
         requestInjection(interceptor);
         bindInterceptor(Matchers.any(), Matchers.annotatedWith(SampleAnnotation.class), interceptor);
     }
}