@RunWith(PowerMockRunner.class)
@PrepareForTest(MySQLDatabaseConnectionFactory.class)
public class MySQLDatabaseConnectionFactoryTest {

    private MySQLDatabaseConnectionFactory reference;

    @Before
    public void setUp() throws Exception {
        reference = new MySQLDatabaseConnectionFactory();
    }

    @Test
    public void testGetConnection() throws SQLException {

        // given
        PowerMockito.mockStatic(DriverManager.class);
        BDDMockito.given(DriverManager.getConnection(anyString(), anyString(), anyString()))
             .willReturn(mock(Connection.class));

        // when
        reference.getConnection();

        // then
        PowerMockito.verifyStatic();
        DriverManager.getConnection("jdbc:mysql://myhost:1111/database", "username", "password");
    }
}