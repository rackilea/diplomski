@RunWith(Parameterized.class)
public class OurTest {
    private String login, password;

    public OurTest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "{index}: Login: ({0}) Password: ({1})")
    public static Collection<Object[]> data() throws FileNotFoundException {
        return new CSVDataProvider().getData();
    }

    @Test
    public void test() {
        System.out.println(String.format("login : %s | Password: %s", login, password));
    }
}