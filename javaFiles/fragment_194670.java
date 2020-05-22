mButtonAdd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mEditText1.getText().toString().length() == 0) {
                mEditText1.setText("0");
            }

            int num1 = Integer.parseInt(mEditText1.getText().toString());
            final int sum = num1 * a;
            String sumValue = String.valueOf(sum);
            mTextViewResult.setText(sumValue);

            AlertDialog alertDialog = new AlertDialog.Builder(BCdaily.this).create(); //Read Update
            alertDialog.setTitle("hi");
            alertDialog.setMessage(sumValue);

            alertDialog.setButton("Continue..", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // here you can add functions
                }
            });

            alertDialog.show();  //<-- See This!

        }

    });