(Button) findViewById(R.id.btnName)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //called when you press the button
                String user =((EditText) findViewById(R.id.txtUser)).getText().toString();
                String password =((EditText) findViewById(R.id.txtPassword)).getText().toString();
                // do the rest of the job
            }
        });