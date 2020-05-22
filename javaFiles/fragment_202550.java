public class CheckingActivity extends Activity {
 Button     button1;
 EditText   txtbox1,txtbox2;
 TextView tv;

 /** Called when the activity is first created. */
 @Override
 public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.main);

 txtbox1=  (EditText) findViewById(R.id.editText1);
 button1 = (Button) findViewById(R.id.button1);
 tv = (TextView) findViewById(R.id.textView5);
 txtbox2=  (EditText) findViewById(R.id.editText2);
 button1.setOnClickListener(new View.OnClickListener() {

public void onClick(View v) 
{
     String a,b;
     Integer vis;
     a =  txtbox1.getText().toString();
     b =  txtbox2.getText().toString();    
     vis =  Integer.parseInt(a)+Integer.parseInt(b);
     //tv.setText(vis.toString());
     Intent i = new Intent(getApplicationContext(),ResultActivity.class);
     i.putExtra("sum",vis.toString());
     startActivity(i);
    }