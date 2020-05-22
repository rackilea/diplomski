@RunWith(MockitoJUnitRunner.class)
public class ConnectionManagementControllerImplTest extends AbstractBaseTest<ConnectionManagementControllerImpl> {

    @Mock
    private ConnectionManagementBusinessService connectionManagementBusinessServiceMocked;

    @InjectMocks
    private ConnectionManagementControllerImpl connectionManagementControllerMocked;

    //constructor can be removed
    public ConnectionManagementControllerImplTest() {
        super();
    }

    @Before
    public void init() throws Exception {
        setTestClass(ConnectionManagementControllerImpl.class, connectionManagementControllerMocked);
        super.init();
    }

    @Test
    public void countConnectionsByInterval() throws Exception {

        // given
        given(connectionManagementBusinessServiceMocked.countConnectionsByInterval(Mockito.anyString()))
                .willReturn(new ArrayList<ConnectionsCountDto>());

        // when
        MockHttpServletResponse response = postResponse("day", MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON_UTF8);

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Override
    protected String getURL() {
        return "/management/countConnectionsByInterval";
    }
}