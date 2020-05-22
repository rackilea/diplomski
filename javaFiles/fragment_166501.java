b1.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                          tv1.clearComposingText();
                          a=Integer.parseInt(t1.getText().toString());
                          tv1.setText(S1+=a);


            }
        });


b2.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                     tv2.clearComposingText();
                         b=Integer.parseInt(t2.getText().toString());
                         tv2.setText(S2+=b);

            }
        });