input1 = Float.parseFloat(et1.getText().toString());
 input2 = Float.parseFloat(et2.getText().toString());
 float sum = input1 + input2;
 String output;

 if (sum >  Math.floor(sum)){
     Toast.makeText(getApplicationContext(), "Decimal", Toast.LENGTH_SHORT).show();
     output = String.valueOf(sum); // pass it as a float
 }
 else{
     Toast.makeText(getApplicationContext(), "Integer", Toast.LENGTH_SHORT).show();
     output = String.valueOf((int) sum); // casts sum to int, removing the ".0"
 }

 tv1.setText(output);