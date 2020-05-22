public class ExceptionFlowTest extends AbstractXmlFlowExecutionTests {

    private MyService myService;

    protected void setUp() {
        myService = new MyService() {

            public ObjectDTO getObject() throws GeneralException {
                throw new GeneralException();
            }

        };
    }

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createFileResource("WebContent/WEB-INF/flows/my-flow.xml");
    }

    @Override
    protected void configureFlowBuilderContext(MockFlowBuilderContext builderContext) {
        builderContext.registerBean("myService", myService);
    }

    public void testMyFlow_Exception() {

        MutableAttributeMap input = new LocalAttributeMap();
        MockExternalContext context = new MockExternalContext();

        startFlow(input, context);

        assertCurrentStateEquals("exceptionViewState");
    }

}