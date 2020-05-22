cal.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(!n1.getText().toString().isEmpty()&&!n2.getText().toString().isEmpty()&&!n3.getText().toString().isEmpty())
        calculateResult();
 else{ //show error message
      }

    }
});



public void calculateResult()
{
      x=Double.parseDouble(n1.getText().toString());
        y=Double.parseDouble(n2.getText().toString());
        z=Double.parseDouble(n3.getText().toString());
        r=(x+y+z)/3;

        answer.setText("" + r);
 }