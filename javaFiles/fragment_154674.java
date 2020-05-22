public class MainActivity extends ActionBarActivity {
    Button btn1;
    TextView tv1;
    EditText edt1;
    String msj= "d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        tv1 = (TextView) findViewById(R.id.tv1);
        edt1 = (EditText) findViewById(R.id.edt1);
        btn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                double n = Double.valueOf(edt1.getText().toString());
                double a = (1 / (Math.sqrt(5))); 
                double b = ((1+(Math.sqrt(5)))/2); 
                double c = ((1-(Math.sqrt(5)))/2); 
                double i = a * ((Math.pow(b,n)) - (Math.pow(c,n)));
                String k = String.valueOf(i);
                msj = edt1.getText().toString();
                tv1.setText( k );               
            }
        });

    }

}