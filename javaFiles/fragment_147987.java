public void calculate(){
    Double value1 = Double.parseDouble(mEditText1.getText().toString());
    Double value2 = Double.parseDouble(mEditText2.getText().toString());
    Double calculatedValue = value1/(value2*value2)*10000;
    calculatedValue = Math.round(calculatedValue*10)/10.0d;
    mTextView.setText(calculatedValue.toString());
    if (calculatedValue >= 10 && calculatedValue < 18) {
      im1.setBackgroundResource(R.drawable.s1);
      m5.setText("low");
    } else if (calculatedValue >= 18 && calculatedValue < 25) {
      im1.setBackgroundResource(R.drawable.s3);
      m5.setText("Best");
    } else if (calculatedValue >= 25 && calculatedValue < 100) {
      im1.setBackgroundResource(R.drawable.s3);
      m5.setText("over");
    }         
  }