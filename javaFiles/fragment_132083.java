public class subCat extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_sub_cat);

 overridePendingTransition(R.layout.one,R.layout.two); //Put it here.

Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
setSupportActionBar(toolbar);
Intent intent = getIntent();
final String idCat = intent.getStringExtra("id");
Toast.makeText(getApplicationContext(),idCat,Toast.LENGTH_LONG).show();
}