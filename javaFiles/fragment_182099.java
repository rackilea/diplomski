@Configuration
@RestController
@RequestMapping("/dummy")
public class DummyController implements WebMvcConfigurer {

  @Target(ElementType.PARAMETER)
  @Retention(RetentionPolicy.RUNTIME)
  @Documented
  @interface BaseData {}

  public static class AbstractBaseData {}

  public static class DataA extends AbstractBaseData {
    public String a;
  }

  public static class DataB extends AbstractBaseData {
    public String b;
  }

  private final MappingJackson2HttpMessageConverter converter;

  DummyController(final MappingJackson2HttpMessageConverter converter) {
    this.converter = converter;
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

    resolvers.add(
        new RequestResponseBodyMethodProcessor(Collections.singletonList(converter)) {

          @Override
          public boolean supportsParameter(MethodParameter parameter) {
            return parameter.hasParameterAnnotation(BaseData.class)
                && parameter.getParameterType() == AbstractBaseData.class;
          }

          @Override
          protected <T> Object readWithMessageConverters(
              NativeWebRequest webRequest, MethodParameter parameter, Type paramType)
              throws IOException, HttpMediaTypeNotSupportedException,
                  HttpMessageNotReadableException {

            final String uri =
                webRequest.getNativeRequest(HttpServletRequest.class).getRequestURI();

            return super.readWithMessageConverters(
                webRequest, parameter, determineActualType(webRequest, uri));
          }

          private Type determineActualType(NativeWebRequest webRequest, String uri) {
            if (uri.endsWith("data-a")) {
              return DataA.class;
            } else if (uri.endsWith("data-b")) {
              return DataB.class;
            }

            throw new HttpMessageNotReadableException(
                "Unable to determine actual type for request URI",
                new ServletServerHttpRequest(
                    webRequest.getNativeRequest(HttpServletRequest.class)));
          }
        });
  }

  @PostMapping(
      path = "/{type}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<? extends AbstractBaseData> post(@BaseData AbstractBaseData baseData) {
    return ResponseEntity.ok(baseData);
  }
}