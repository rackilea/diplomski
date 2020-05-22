public class MainActivity extends AppCompatActivity {

    private int x;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        x = prefs.getInt("count", 0);

        final TextView number=(TextView) findViewById(R.id.numbers);
        ImageButton btn_count=(ImageButton) findViewById(R.id.btn_countn);
        ImageButton btn_reset=(ImageButton) findViewById(R.id.btn_resetn);

        number.setText(String.valueOf(x));

        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x++;
                prefs.edit().putInt("count", x).apply();
                number.setText(String.valueOf(x));
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=0;
                prefs.edit().putInt("count", x).apply();
                number.setText(String.valueOf(x));
            }
        });
    }
}