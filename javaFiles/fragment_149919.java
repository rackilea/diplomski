public abstract class AbstractBaseTest<C> {

    public MockMvc mockMvc;

    private Class<C> clazz;

    private Object inject;

    protected abstract String getURL();

    protected final void setTestClass(final Class<C> classToSet, final Object injectToSet) {
        clazz = Preconditions.checkNotNull(classToSet);
        inject = Preconditions.checkNotNull(injectToSet);
    }

    @Before //this annotation can be removed
    public void init() throws Exception {
        MockitoAnnotations.initMocks(clazz); //this line also can be removed because MockitoJUnitRunner does it for you
        mockMvc = MockMvcBuilders.standaloneSetup(inject).build();
    }

    protected MockHttpServletResponse getResponse(MediaType produces) throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                get(getURL()).
                        accept(produces)).
                andReturn().
                getResponse();
        return response;
    }

    protected MockHttpServletResponse postResponse(String content , MediaType consumes , MediaType produces) throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                post(getURL()).
                        content(content).
                        contentType(consumes).
                        accept(produces)).
                andReturn().
                getResponse();
        return response;
    }
}