public class ResultActivity extends Activity {
TextView tv;
String result;
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.resultview);
Bundle extras = getIntent().getExtras();
if (extras != null) {
    result = extras.getString("sum");
    }
tv=(TextView) findViewById(R.id.tvres);    
tv.setText(result);
  }
 }