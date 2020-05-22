mBTIncrement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int mValue = Integer.parseInt(_value.getText().toString());
                    mValue++;
                    _value.setText("" + mValue);
                }
            });

            _decrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int mValue = Integer.parseInt(_value.getText().toString());
                    mValue--;

                    if (mValue < 0) {
                        System.out.println("not valid");
                    } else
                    {
                        _value.setText( ""+mValue );

                    }
                }
            });