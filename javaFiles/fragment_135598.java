public class RequestMappingTest {

  private MockHttpServletRequest request;
  private MockHttpServletResponse response;
  private MyController controller;
  private AnnotationMethodHandlerAdapter adapter;


  @Before
  public void setUp() {

    controller = EasyMock.createNiceMock(MyController.class);

    adapter = new AnnotationMethodHandlerAdapter();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }


  @Test
  public void testname() throws Exception {

    request.setRequestURI("/users");

    controller.foo(response);
    EasyMock.expectLastCall().once();
    EasyMock.replay(controller);

    adapter.handle(request, response, controller);

    EasyMock.verify(controller);
  }
}