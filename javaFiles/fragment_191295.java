RelativeLayout relativeLayout;

public class YourActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.NameOfLayout);

        relativeLayout = (RelativeLayout)findViewById(R.id.mylayout);

        relativeLayout.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
         Intent myintent = new Intent(getApplicationContext(), some.class);
         startActivity(myintent);
        }
       });
     }