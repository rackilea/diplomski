final EditText editText1 = (EditText)findViewById(R.id.editText1);
      final EditText editText2 = (EditText) findViewById(R.id.editText2);
      final EditText editText3 = (EditText) findViewById(R.id.editText3);

     if (editText1.getText().toString().trim().equals("")) {
        Toast.makeText(this, "Enter thick",Toast.LENGTH_SHORT).show();
         return;
                    }   
     if (editText2.getText().toString().trim().equals("")) {
        Toast.makeText(this, "Enter width",Toast.LENGTH_SHORT).show();
         return;
                    }
     if (editText3.getText().toString().trim().equals("")) {
        Toast.makeText(this, "Enter length",Toast.LENGTH_SHORT).show();
         return;
                    } 

     double thick = Double.valueOf(editText1.getText().toString());
     double width = Double.valueOf(editText2.getText().toString());
     double length = Double.valueOf(editText3.getText().toString());