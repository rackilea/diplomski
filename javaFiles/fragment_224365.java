public class MainActivity extends Activity  {

    TextView campagne;
    String user = "toto";
    String password = "tata";
    String theCampagneXml; // new

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campagne = (TextView) findViewById(R.id.text);
        postData(user, password); // new
    }

public void postData(final String login, final String password) { // note: the return type has been changed

Thread background = new Thread(new Runnable() {
    URL url;
    String buffer;
    String theCampagneXml = null; // new

    @Override
    public void run() {
        try {
            // no changes here but declaring `theCampagneXml` as class member
        }
        campagne.post(new Runnable() {

            @Override
            public void run() {
                campagne.setText("hello, here is your XML : "+ theCampagneXml);
            }
        });
    }
});

background.start();
}
}