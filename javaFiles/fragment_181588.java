@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-app-ctx.xml")
public class FooTest {

    @Autowired
    @InjectMocks
    TestTarget sut;

    @Mock
    Foo mockFoo;

    @Before
    /* Initialized mocks */
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void someTest() {
         // ....
    }
}