public class PersonServiceTest {

    @InjectMocks
    PersonService personService;

    @Mock
    MockedClass myMock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.doReturn("Whatever you want returned").when(myMock).mockMethod;


    }

    @Test()
      public void testPerson() {

         assertThat(personService.method, "what you expect");
      }