public class MainActivity extends Activity implements OnClickListener {
     EditText et;
     Button btm;
     TextView tv;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          et = (EditText)findViewById(R.id.editText1);
          btm = (Button)findViewById(R.id.button1);
          tv = (TextView)findViewById(R.id.textView1);
          btm.setOnClickListener(this);
     }

     @Override
     public void onClick(View v) {
         if(v.getId==btm.getId()) tv.setText(et.getText().toString());
     }
}