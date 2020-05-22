public class SplashScreenActivity extends AppCompatActivity {

    @Inject SessionKeyExchangerService exchangerService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Injector.INSTANCE.getAppComponent().inject(this);

        // establish the session id as a singleton object
        // exchangerService = component.provideSessionKeyExchangerService(); //totally not needed

        // test whether I can access the singleton from another class
        exchangerService.sendEncryptedKeyToServer();