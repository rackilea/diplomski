Spinner sp1 =(Spinner)findViewById(R.id.sp1);
Spinner sp2 = (Spinner)findViewById(R.id.sp2);
TextView textElement = (TextView)findViewById(R.id.txResult);              
Button showResult = (Button)findViewById(R.id.btnShowResult);

showResult.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           String txtFromSpinner1 = sp1.getSelectedItem().toString();
         String txtFromSpinner2 = sp2.getSelectedItem().toString();

         if (txtFromSpinner1.equals("1")&& txtFromSpinner2.equals("2"))
                textElement.setText("3");


        }
    });