@Configuration
@EnableMBeanExport
public class SpringConfiguration {
   @Bean
   protected CountingHttpInterceptor countingHttpInterceptor() {
      return new CountingHttpInterceptor();
   }
}