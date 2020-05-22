EditText eText1, eText2;
TextView result;
double n1,n2,sum;
Button btn;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.);
    eText1 = (EditText) findViewById(R.id.eText1);
    eText2 = (EditText) findViewById(R.id.eText2);
    btn = (Button) findViewById(R.id.button);
    result = (TextView)findViewById(R.id.textView);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          n1 = Double.parseDouble(eText1.getText().toString());
          n2 = Double.parseDouble(eText2.getText().toString());
            sum = n1 +n2;
            result.setText(Double.toString(sum));
        }


    });
}