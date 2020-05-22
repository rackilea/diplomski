public class YourActivityName extends AppCompatActivity {


TextView operand1, operand2,result,tv;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.dd);

    operand1 = (TextView) findViewById(R.id.textView);
    operand2 = (TextView) findViewById(R.id.textView2);

    result= (TextView) findViewById(R.id.textView3);
    tv=operand1;
}


public void sendMessage(View v) {
    if (v.getId() == R.id.button19 || v.getId() == R.id.button15 || v.getId() == R.id.button17 || v.getId() == R.id.button21 || v.getId() == R.id.button18) {
        tv=operand2;
    }

    if(v.getId()==R.id.button7){
        tv.setText(tv.getText()+"7");
    }

    if(v.getId()==R.id.button8){
        tv.setText(tv.getText()+"8");
    }

    if(v.getId()==R.id.button23){
        int op1=Integer.parseInt(operand1.getText().toString());
        int op2=Integer.parseInt(operand2.getText().toString());
        op2+=op1;
        result.setText(op2+"");
        tv=operand1;
        operand1.setText("");
        operand2.setText("");
    }

}