public class MainActivity extends Activity {
LinearLayout LL;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    LL=(LinearLayout) findViewById(R.id.linear_splash);
    LL.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            Intent intent=new Intent(MainActivity.this,Second.class);
            finish();
            startActivity(intent);
        }
    });

}