public class ActivitySecond extends ActionBarActivity {

Button btnWaitEnable;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    btnWaitEnable = (Button) findViewById(R.id.btnWaitEnable);

    btnWaitEnable.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            //This statement will return the opposite of what 
            //is stored in that public static boolean variable
            ActivityFirst.status = (ActivityFirst.status == true)?false:true;

        }
    });

}