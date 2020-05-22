public class Cart extends Activity {

TextView mTextview;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.Cart);

    aTextview = (TextView)findViewById(R.id.textView);

    aTextview.setText(getIntent().getStringExtra("mytext"));
}