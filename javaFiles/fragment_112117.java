public interface MyService
{
    String blammy(SomeParameter parameter);
}

public class UsesMyService
{
    @Autowired
    private MyService myService;

    public String kapow(final SomeParameter parameter)
    {
        return myService.blammy(parameter);
    }
}

public class UnitTestUsesMyService
{
    private UsesMyService classToTest;

    @Mock
    private MyService mockMyService;

    @Mock
    private SomeParameter mockSomeParameter;

    @Before
    public void preTestSetup()
    {
        MockitoAnnotations.initMocks(this);

        classToTest = new UsesMyService();

        doReturn("Blam").when(mockMyService).blammy(mockSomeParameter);

        ReflectionTestUtils.setField(
            classToTest,
            "myService",
            mockMyService);
    }

    @Test
    public void kapow_allGood_success()
    {
        final String actualResult;


        actualResult = classToTest.kapow(mockSomeParameter);


        assertNotNull(actualResult); // Not strictly necessary.

        assertEquals(
            "Blam",
            actualResult);
    }
}