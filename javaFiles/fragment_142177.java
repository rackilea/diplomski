@RunWith(MockitoJUnitRunner.class)
public class AbcControllerTest {

    @Mock
    private XyzService mockXyzService;

    @Mock
    private MyProperty myProperty;

    @InjectMocks
    private AbcController controllerUnderTest;

    @Before
    public void setUp(){
        when(myProperty.get()).thenReturn("my property value");
    }

    /* tests */
}