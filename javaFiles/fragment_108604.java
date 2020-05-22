public class test extends Activity {
    boolean showTV1 = true;

    OnClickListener ocl = new OnClickListener() {
        @Override
        public void onClick(View v) {
            showTV1= !showTV1;
            if (showTV1){
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.GONE);
                tv1.requestFocus();
            } else {
                tv2.setVisibility(View.VISIBLE);
                tv1.setVisibility(View.GONE);
                tv2.requestFocus();
            }
        }
    };

    private TextView tv1, tv2;  

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv1 = (TextView) findViewById(R.id.TextView01); 
        tv2 = (TextView) findViewById(R.id.TextView02);

        tv1.setOnClickListener(ocl);
        tv2.setOnClickListener(ocl);
    }
}