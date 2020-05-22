...
        final EditText XEmail = (EditText) mView.findViewById(R.id.etEmail);
        final EditText Xpassword = (EditText) mView.findViewById(R.id.etPassword);
        Button XLogbtn = (Button) mView.findViewById(R.id.Logbtn);
        Button XNtnbtn = (Button) mView.findViewById(R.id.ntnbtn);

        // Changes here
        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();


        XLogbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!XEmail.getText().toString().isEmpty() && !Xpassword.getText().toString().isEmpty())
                {
                    Toast.makeText(Console_Activity.this, R.string.successful_login, Toast.LENGTH_SHORT).show();
                    xShowDialog.setImageResource(R.drawable.xboxbuttongreen);


         dialog.dismiss();


                }
                else
                {
                    Toast.makeText(Console_Activity.this, R.string.error_login_message, Toast.LENGTH_SHORT).show();
                }
            }
        });




        XNtnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 //changes here
                dialog.dismiss();
            }
        });

        //changes here
        dialog.show();

    }