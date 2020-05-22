public class TSActivity extends Activity {

     String str = "";
     String str1 = "";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button btn = (Button)findViewById(R.id.btn);
        TextView txt = (TextView)findViewById(R.id.text);
        TextView txt1 = (TextView)findViewById(R.id.text1);
        btn.setEnabled(false);


        txt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                    int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

                str = s.toString();
                if( !(str.equals("")) && !(str1.equals("")) )
                {
                    btn.setEnabled(true);
                }
                else
                {
                    btn.setEnabled(false);
                }
            }
        });
 /**************************************************************************************************/       
        txt1.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub              
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                    int after) {
                // TODO Auto-generated method stub              
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

                str1 = s.toString();
                if( !(str.equals("")) && !(str1.equals("")) )
                {
                    btn.setEnabled(true);
                }
                else
                {
                    btn.setEnabled(false);
                }
            }
        });
    }  
}