public class DataEntryActivity extends Activity{

    private static String username;
    private static String mail;

    @Override
    public void onCreate(Bundle b){
         super.onCreate(b);
         setContentView(R.layout.layout_data_entry);
         EditText et1 = (EditText) findViewById(R.id.editTextUsername);
         EditText et2 = (EditText) findViewById(R.id.editTextMail);
         if (username != null)
              et1.setText(username);
         if (mail != null)
              et2.setText(mail);
         Button save = (Button) findViewById(R.id.saveButton);
         save.setOnClickListener(new OnClickListener(){

              public void onClick(View v){

                   if (et1.getText().toString().length() > 0)
                        username = et1.getText().toString();
                   if (et2.getText().toString().length() > 0)
                        mail = et2.getText().toString();
                   Intent intent = new Intent(DataEntryActivity.this, YourOtherActivity.class);
                   startActivity(intent);
              }

         });

    }


    public static String getUsername(){
         return username;
    }

    public static String getMail(){
         return mail;
    }

}