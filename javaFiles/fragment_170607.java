public class MainActivity extends AppCompatActivity {
String input1, input2, input3;
EditText tankVolume, fillingPressure, flowRate;
TextView fillingTime;
Button calculate, ClearButton;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    tankVolume=(EditText)findViewById(R.id.tankVolume);
    fillingPressure=(EditText)findViewById(R.id.fillingPressure);
    flowRate=(EditText)findViewById(R.id.flowRate);
    fillingTime=(TextView)findViewById(R.id.fillingTime);
    calculate=(Button)findViewById(R.id.calculate);

    // remove on touch the value entries in the Flow rate field to start calculation
    // if no value is entered the field will return to his normal state (0.0)
    input3 = String.valueOf(flowRate.getText());
    flowRate.setOnFocusChangeListener(new View.OnFocusChangeListener() {

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if ((hasFocus)&&(input3.equals("0.0") || input3.equals(""))) {
                flowRate.setText("");
            }
            input3 = (String.valueOf(flowRate.getText()));
            if ((!hasFocus) && (input3.equals(""))){
                flowRate.setText("0.0");
            }
        }
    });
    // remove on touch the value entries in the Flow rate field to start calculation
    // if no value is entered the field will return to his normal state (0.0)
    input2 = String.valueOf(fillingPressure.getText());
    fillingPressure.setOnFocusChangeListener(new View.OnFocusChangeListener() {

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if ((hasFocus)&&(input2.equals("0.0") || input2.equals(""))) {
                fillingPressure.setText("");
            }
            input2 = (String.valueOf(fillingPressure.getText()));
            if ((!hasFocus) && (input2.equals(""))){
                fillingPressure.setText("0.0");
            }
        }
    });
     // remove on touch the value entries in the Flow rate field to start calculation
    // if no value is entered the field will return to his normal state (0.0)
    input1 = String.valueOf(tankVolume.getText());
    tankVolume.setOnFocusChangeListener(new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if ((hasFocus)&&(input1.equals("0.0") || input1.equals(""))) {
                tankVolume.setText("");
            }
            input1 = (String.valueOf(tankVolume.getText()));
            if ((!hasFocus) && (input1.equals(""))){
                tankVolume.setText("0.0");
            }

        }
    });

    // calculate the filling time
    calculate.setOnClickListener(new Button.OnClickListener()

    {
        public void onClick
                (View v) {
            calculate();
        }
    });
}

private void calculate()
{

    Double value1 = Double.parseDouble(tankVolume.getText().toString());
    Double value2 = Double.parseDouble(fillingPressure.getText().toString());
    Double value3 = Double.parseDouble(flowRate.getText().toString());
    Double calculatedValue = (value1*value2)/value3;


    fillingTime.setText(calculatedValue.toString());
}



    // reset everything to zero
    public void clear(View v) {
        tankVolume.setText("0.0");
        fillingPressure.setText("0.0");
        flowRate.setText("0.0");
        fillingTime.setText("0");
        tankVolume.clearFocus();
        fillingPressure.clearFocus();
        flowRate.clearFocus();
    }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
        return true;
    }

    return super.onOptionsItemSelected(item);
}
}