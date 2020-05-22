@Configuration
@EnableAspectJAutoProxy
public class SpringDataExecutionLoggingConfiguration {

  @Bean
  public CustomizableTraceInterceptor customizableTraceInterceptor() {

    CustomizableTraceInterceptor customizableTraceInterceptor = new CustomizableTraceInterceptor();
    customizableTraceInterceptor.setUseDynamicLogger(true);
    customizableTraceInterceptor.setExitMessage("Executed $[methodName] in $[invocationTime]");
    return customizableTraceInterceptor;
  }

  @Bean
  public Advisor advisor() {

    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    pointcut.setExpression("execution(public * org.springframework.data.jpa.repository.CrudRepository+.*(..))");
    return new DefaultPointcutAdvisor(pointcut, customizableTraceInterceptor());
  }
}