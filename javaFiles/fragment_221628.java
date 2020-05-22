public class Edit extends ActionBarActivity {

EditText name;
EditText surName;
EditText date;
EditText time;
EditText eDate;
EditText eTime;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edit);


    Intent intent = getIntent();
     String data_name = intent.getStringExtra("name");
     String data_surname = intent.getStringExtra("surname");
     String data_enterdate= intent.getStringExtra("enterdate");
     String data_entertime = intent.getStringExtra("entertime");
     String data_exitdate = intent.getStringExtra("exitdate");
     String data_exittime = intent.getStringExtra("surname"); //typo here


     name = (EditText) findViewById(R.id.username); //corrected
     surName = (EditText) findViewById(R.id.usersurname); //corrected
     date = (EditText) findViewById(R.id.date2);
     time = (EditText) findViewById(R.id.time2);
     eDate = (EditText) findViewById(R.id.date3);
     eTime = (EditText) findViewById(R.id.time3);

     name.setText(data_name);
     surName.setText(data_surname);
     date.setText(data_enterdate);
     time.setText(data_entertime);
     eDate.setText(data_exitdate);
     eTime.setText(data_exittime);
}


public void onCancel(View btnCancel){
finish();
 }
 public void onSave(View btnSave){

 }
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.edit, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
        return true;
    }
    return super.onOptionsItemSelected(item);
}
  }