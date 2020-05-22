public class MainActivity extends Activity implements View.OnClickListener {


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.thecloset);

    Button button = (Button) findViewById(R.id.button1);
    ImageView img = (ImageView) findViewById(R.id.image);

    button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            img.setImageResource(R.drawable.image2);

            }
    });