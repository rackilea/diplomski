public class Main extends Activity {

Button listButton;
View splash2;  // Added

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ...
    setContentView(R.layout.splash);
    SplashPager adapter = new SplashPager();
    ViewPager myPager = (ViewPager) findViewById(R.id.splashPager);
    ....
    LayoutInflater inflater = getLayoutInflater(); // Added
    splash2 = inflater.inflate (R.layout.splash2, null); // Added
    myPager.add (splash2); // Added

    listButtonListener();
}

public void listButtonListener() {

    listButton = (Button) splash2.findViewById(R.id.splashB); // Changed
    listButton.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            setContentView(R.layout.list_layout);
        }
    });
}