public class StartScreen extends Activity {
      @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start_screen);

    Button button = (Button) findViewById(R.id.your_button);
    button.setOnClickListener(new View.OnClickListener() {

        public void onClick(View view) {
            Intent activityChangeIntent = new Intent(StartScreen.this,QuizMenu.class);
            StartScreen.this.startActivity(activityChangeIntent);

        }
    });