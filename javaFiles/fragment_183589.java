String digits = "";
 one.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
          digits += "1";
          Display.setText(digits);
       }
   });
   two.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           digits += "2";
           Display.setText(digits);
       }
   });