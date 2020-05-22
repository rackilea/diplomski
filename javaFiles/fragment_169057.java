@RunWith(PowerMockRunner.class)
@PrepareForTest(ExampleController.class)
public class ExampleControllerTest
{
    private SomeClass someClass;
    private MockMvc exampleControllerMockMvc;

    @Before
    public void before() {
        someClass = Mockito.mock(SomeClass.class);
        PowerMockito.whenNew(SomeClass.class).withNoArguments().thenReturn(someClass);
        exampleControllerMockMvc = MockMvcBuilders.standaloneSetup(new ExampleController())
                                                  .build();
    }

    @Test
    public void exampleControllerTest_IllegalArgumentException_throwsInternalException() {
        Mockito.doThrow(new IllegalArgumentException).when(someClass).getData();
        exampleControllerMockMvc.perform(get("/samplePage"))
                                .andExpect(status().is5xxServerError);  
    }
}