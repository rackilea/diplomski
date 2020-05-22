@Configuration
@Slf4j
public class MvcConfig implements WebMvcConfigurer {
  @Override
  public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
    resolvers.add(0, new MethodArgumentTypeMismatchExceptionLoggingExceptionHandler());
  }
}