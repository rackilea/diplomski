public class LoginActivity extends AppCompatActivity implements LoaderCallbacks<Cursor>,IServiceHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ............
        ............
        ............
        CasAuthentication casAuthentication = new CasAuthentication(this);
        String expectedResult = casAuthentication.getTicketGrantingTicket(username, password, hostUrl, casUrl)

    }}