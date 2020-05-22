public class SomeServiceTest {
    @Mock
    private SomeRepository someRepository;

    private SomeService someService;

    @Before
    public void setUp() {
         MockitoAnnotations.initMocks(this);
         someService = new SomeService(someRepository);
    }

    /* ... */
}