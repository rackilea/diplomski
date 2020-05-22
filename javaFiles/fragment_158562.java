edtFirstName.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
           edtFirstName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
               @Override
               public void onFocusChange(View v, boolean hasFocus) {

                   if (!edtFirstName.hasFocus()) {
                       if (edtFirstName.getText().toString().isEmpty()) {
                           tilFName.setError("Must not be empty.");
                       } else {
                           tilFName.setError(null);
                       }
                   }

               }
           });

            return false;
        }
    });

    edtLastName.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            edtLastName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {

                    if(!edtLastName.hasFocus()) {
                        if (edtLastName.getText().toString().isEmpty()) {
                            tilLName.setError("Must not be empty.");
                        } else {
                            tilLName.setError(null);
                        }
                    }
                }
            });

            return false;
        }
    });