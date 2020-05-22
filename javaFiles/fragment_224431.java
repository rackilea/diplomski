public class MainActivity extends Activity implements OnClickListener{

Button btnOk;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //find id of your button
    btnOk = (Button) findViewById(R.id.btnOk);

    //Registering it for click listener
    btnOk.setOnClickListener(this);

}

@Override
public void onClick(View v) {

    switch (v.getId()) {
    case R.id.btnOk:

        System.out.println("OK button is clicked");

        break;

    case 2:
        //some other controls

        break; 

    default:
        break;
    }

}