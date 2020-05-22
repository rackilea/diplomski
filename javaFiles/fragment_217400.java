submit = (Button)findViewById(R.id.submit);
    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

           //First get the selected country name
           String sp1Val = spinner1.getSelectedItem().toString();
           String sp2Val = spinner2.getSelectedItem().toString();

           // Then compare both spinner values:
          if(sp1Value.equals("Bangladesh") && sp2Val.equals("India")){
                Intent i = new Intent(MainActivity.this, BDTOINDActivity.class);
                startActivity(i);
          }

           //Do the rest of them as same
        }
    });