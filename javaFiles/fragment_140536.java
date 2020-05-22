public class MainActivity extends AppCompatActivity {

public Integer number = 0;
//i would use this instead of the above
private int number = 0;
private TextView tv;
private ImageButton button;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
    tv = (TextView) findViewById(R.id.no1);
    button = (ImageButton) findViewById(R.id.zeroB);

    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            number++;
            tv.setText(String.valueOf(number));
        }
    });
}
...