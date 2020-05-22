public class MyExceptionMapperTest {
  @Mocked
  private HttpServletRequest mockHttpServletRequest;

  @Mocked
  private HttpServletResponse mockHttpServletResponse;

  private MyExceptionMapper exceptionMapper = new MyExceptionMapper();

  @Before
  public void setup() {
    Field httpServletRequest = exceptionMapper.getClass().getDeclaredField("httpServletRequest");
    httpServletRequest.setAccessible(true);
    httpServletRequest.set(exceptionMapper, mockHttpServletRequest);

    Field httpServletResponse = exceptionMapper.getClass().getDeclaredField("httpServletResponse");
    httpServletResponse.setAccessible(true);
    httpServletResponse.set(exceptionMapper, mockHttpServletResponse);
  }
}