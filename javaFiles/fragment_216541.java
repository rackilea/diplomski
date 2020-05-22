public class ActivityFirst extends ActionBarActivity implements OnClickListener {

Button btnCallActivitySecond;
Button btnWaiting;

//variable that maintains the state of button
public static boolean status = false;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_first);


    btnCallActivitySecond = (Button) findViewById(R.id.btnActCall);
    btnWaiting = (Button) findViewById(R.id.btnWainting);       

    btnWaiting.setEnabled(status);

    btnCallActivitySecond.setOnClickListener(this);
    btnWaiting.setOnClickListener(this);
}
/*This method will be called each time
  whenever you press back button from second activity*/
@Override
protected void onRestart() {
    // TODO Auto-generated method stub
    super.onRestart();
    btnWaiting.setEnabled(status);
    Toast.makeText(this, "restart "+ status, Toast.LENGTH_LONG).show();
}
@Override
public void onClick(View arg0) {
    // TODO Auto-generated method stub
    switch (arg0.getId()) {
    case R.id.btnActCall:
        Intent i = new Intent(this, ActivitySecond.class);
        i.putExtra("status", status);
        startActivity(i);
        break;
    case R.id.btnWainting:
        Toast.makeText(this, " "+ status, Toast.LENGTH_LONG).show();
        break;
    }


}  ... }