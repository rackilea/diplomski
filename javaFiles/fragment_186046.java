public class MainActivity extends YouTubeFailureRecoveryActivity {

    Button amazonButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
    }

    private void initializeViews() {
        //Make sure you've declared the buttons before you initialize them. 
        amazonButton = (Button) findViewById(R.id.amazonButton);
        amazonButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Define what should happen when the button is clicked. 
            }
        });

        // Add more Views initialization here ...
        ....
    }

}