@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);



    TextView tPrincipalAmount   = (TextView)findViewById(R.id.tPrincipalAmount);
    EditText editPrincipalAmount= (EditText)findViewById(R.id.editPrincipalAmount);
    String String_Principal_amount = editPrincipalAmount.getText().toString();
    double DbPrincipalAmount = 0;

    if (String_Principal_amount != null && !String_Principal_amount.equals("")) {

        DbPrincipalAmount = Double.parseDouble(String_Principal_amount);

    }


    TextView tInterestRate =(TextView) findViewById(R.id.tInterestRate);
    EditText editInterestRate =(EditText) findViewById(R.id.editInterestRate);
    String string_editInterestRate =editInterestRate.getText().toString();

    double DbInterestRate = 0;

    if (string_editInterestRate != null && !string_editInterestRate.equals("")) {

        DbInterestRate = Double.parseDouble(string_editInterestRate);

     }


}