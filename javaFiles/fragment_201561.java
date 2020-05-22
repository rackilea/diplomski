public class SampleActivity extends Activity {
    TextWatcher tt = null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final EditText et = (EditText) findViewById(R.id.editText1);
        final TextView tv = (TextView) findViewById(R.id.textView1);
        tt = new TextWatcher() {
           public void afterTextChanged(Editable s){
                et.setSelection(s.length());
           }
           public void beforeTextChanged(CharSequence s,int start,int count, int after){} 
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               et.removeTextChangedListener(tt);
               et.setText(et.getText().toString().replace("A", "C"));
               et.addTextChangedListener(tt);
           }
       };
       et.addTextChangedListener(tt);
   }
}