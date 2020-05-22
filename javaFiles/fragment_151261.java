public void onButtonClick (View v)
{
    int num1 = 0,num2 = 0,sum = 0;
    EditText e1 = (EditText)findViewById(R.id.num1);
    EditText e2 = (EditText)findViewById(R.id.num2);

    TextView t1 = (TextView)findViewById(R.id.sum);
    if(!(e1.getText().toString()).equals(""))
       num1 = Integer.parseInt(e1.getText().toString());
    if(!(e2.getText().toString()).equals(""))
       num2 = Integer.parseInt(e2.getText().toString());

    sum = num1 + num2 ;

    t1.setText(sum.toString());
}