public class MainActivity extends YouTubeFailureRecoveryActivity {

    Button amazonButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amazonButton = (Button) findViewById(R.id.amazonButton);
        amazonButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Define what should happen when the button is clicked. 
            }
        });
    }
}