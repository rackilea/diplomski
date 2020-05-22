public class MainActivity extends AppCompatActivity {
int balance;;
private SharedPreferences preferences;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //Hide notification bar
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    //Click counter
    final TextView text = (TextView) findViewById(R.id.balance_text);
    assert text != null;
    // to retreuve the values from the shared preference
    preferences = PreferenceManager.getDefaultSharedPreferences(this);
    balance = preferences.getInt("balance", 0);
    text.setText(balance + " $");
    final ImageButton button = (ImageButton) findViewById(R.id.click_button);
    assert button != null;
    button.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            balance++;
            text.setText("" + balance + " $");
        }
    });
}