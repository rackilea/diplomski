public void onClick(View arg0) {

            et=(EditText)findViewById(R.id.text);
            txt=et.getText().toString();

            new Read().execute("displayprice");

        }

    });