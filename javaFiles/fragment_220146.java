public  class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, zerobtn, dotbtn, equalbtn, minusbtn, sumbtn, divbtn, mulbtn;
double num1, num2;
boolean sum, minus, div, mul;
EditText textarea;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_calculator);

    textarea = (EditText) findViewById(R.id.textarea);