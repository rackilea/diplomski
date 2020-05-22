@RunWith(SpringRunner.class)
 public class MembersControllerTest {

     @Mock
     DataSource dataSource;

     @Mock
     Cryptography stringCrypto;

     @Mock
     NamedParameterJdbcTemplate namedParameterJdbcTemplate;

     @InjectMocks
     PersonDAOImpl personDAOImpl;

     @BeforeEach
     void setUp() {
         MockitoAnnotations.initMocks(this);
     }

  @Test
  public void test() {

    when(namedParameterJdbcTemplate.query(ArgumentMatchers.anyString(),
                                          ArgumentMatchers.any(MemberExtractor.class))
                                         .thenReturn(//List<Members>);
    assertTrue(personDAOImpl.getAllMembers().size() > 0);

     }

 }