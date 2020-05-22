@RunWith(MockitoJUnitRunner.class)
public class FilterAnnotationTest {

    @Mock
    private ResourceInfo resourceInfo;

    @Mock
    private ContainerRequestContext context;

    @Spy
    private Service service;

    private MyFilter filter;

    @Before
    public void setUp() {
        filter = new MyFilter(resourceInfo, service);
    }

    @Test
    public void testEnumOne() throws Exception {
       Method methodOne = MockClass.class.getDeclaredMethod("enumOne");
       Mockito.when(resourceInfo.getResourceMethod()).thenReturn(methodOne);

       filter.filter(context);
       Mockito.verify(service).methodOne();
    }

    @Test
    public void testEnumTwo() throws Exception {
        Method methodTwo = MockClass.class.getDeclaredMethod("enumTwo");
        Mockito.when(resourceInfo.getResourceMethod()).thenReturn(methodTwo);

        filter.filter(context);
        Mockito.verify(service).methodTwo();
    }


    private enum MyEnum {
        VALUE1, VALUE2
    }

    @Target({ METHOD })
    @Retention(RUNTIME)
    private @interface MyAnnotation {
         MyEnum info();
    }

    private static class MyFilter implements ContainerRequestFilter {

        private final ResourceInfo resourceInfo;
        private final Service service;

        @Inject
        public MyFilter(ResourceInfo resourceInfo, Service service) {
            this.resourceInfo = resourceInfo;
            this.service = service;
        }

        @Override
        public void filter(ContainerRequestContext containerRequestContext) throws IOException {
            MyAnnotation anno = resourceInfo.getResourceMethod().getAnnotation(MyAnnotation.class);
            if (anno.info() == MyEnum.VALUE1) {
                service.methodOne();
            } else if (anno.info() == MyEnum.VALUE2) {
                service.methodTwo();
            }
        }
    }

    private static class MockClass {
        @MyAnnotation(info=MyEnum.VALUE1)
        public void enumOne() {}
        @MyAnnotation(info=MyEnum.VALUE2)
        public void enumTwo() {}
    }

    public interface Service {
        void methodOne();
        void methodTwo();
    }
}