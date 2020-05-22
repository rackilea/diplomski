float ab=-1;


    unary=(Button)findViewById(R.id.plusminus); 
    mod=(Button)findViewById(R.id.modul); 

    unary.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View v) {
                txtScreen.setText(String.valueOf(ab * Float.valueOf(txtScreen.getText().toString())));
            } 
        });