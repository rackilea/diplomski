public class MainActivity8 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main8);

String Kategorie1 =getIntent().getStringExtra("Kate1");

TextView tv = (TextView) findViewById(R.id. textView2);
tv.setText(Kategorie1);
}
}