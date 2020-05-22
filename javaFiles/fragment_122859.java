EditText payable;
Button calculate;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    EditText salary = (EditText) findViewById(R.id.edit_salary);
    EditText allowance = (EditText) findViewById(R.id.edit_allowance);
    EditText incomeTax = (EditText) findViewById(R.id.IncTax_edit);
    EditText payable = (EditText) findViewById(R.id.payable_edit);
    EditText totalTax = (EditText) findViewById(R.id.deduction_edit);
    Button calculate = (Button) findViewById(R.id.calculate_button);

          if(salary.getText().toString().length()>0)
         {
         double realSalary=Double.parseDouble(salary.getText().toString());
         }
          if(allowance.getText().toString().length()>0)
         {
          double realAllowance = Double.parseDouble(allowance.getText().toString());

         }