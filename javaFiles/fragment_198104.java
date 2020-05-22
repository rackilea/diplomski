conv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // here you get the text from your editText
                x = new Integer(ent1.getText().toString());

                // do something with the text
                counter = x/100;

                // set result in another TextView
                dis1.setText("In Metres: " +counter);

                // work is done, so the editText can be cleared
                ent1.setText("");

            }
    });