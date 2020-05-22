public class MainActivity extends AppCompatActivity {

private Button button;
Context context;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    context = this;

    Button button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MediaPlayer mp = MediaPlayer.create(context, R.raw.shotgun);
            mp.start();
        }
    });