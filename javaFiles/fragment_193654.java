public class MainActivity extends AppCompatActivity {

    TextView textView;
    CountDownTimer mycounterdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long startcard = 10000;
        textView = (TextView) findViewById(R.id.test);

        mycounterdown = new CountDownTimer(startcard, 1000) {
            @Override
            public void onTick(long mycounterup) {
                int minutes_up_start = (int) (mycounterup / 1000) / 60;
                int seconds_up_start = (int) (mycounterup / 1000) % 60;
                String time_2_up_start_formatted = String.format(Locale.getDefault(), "%02d:%02d", minutes_up_start, seconds_up_start);
                textView.setText(time_2_up_start_formatted);
            }

            @Override
            public void onFinish() {
                // call here other methods from activity

                testMethod();
            }
        };
        mycounterdown.start();

    }
    public void testMethod(){
        Toast.makeText(MainActivity.this, "Test Method called", Toast.LENGTH_SHORT).show();
    }

}