@Component
public class MyAuthenticator extends Authenticator {
    @Value("${credentials.username}")
    private final String userName;
    @Value("${credentials.password}")
    private final String passWord;

    public MyAuthenticator(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.userName, this.passWord.toCharArray());
    }
}