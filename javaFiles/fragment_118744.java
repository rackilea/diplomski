calculateBtn = (Button) findViewById(R.id.**[youIdButton]**);
startDate = (EditText) findViewById(R.id.**[endDate]**);
endDate = (EditText) findViewById(R.id.**[endDate]**);
result = () findViewById(R.id.**[result]**);

calculate.setOnClickListener(new OnClickListener(){

       result.setText(calculate(startDate.getText().toString(), endDate.getText().toString()));
});