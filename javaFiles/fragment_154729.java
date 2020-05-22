yourEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //do something
                    myIP = theIP.getText().toString(); 
            validIP = ipvalidator.validate(myIP);
                }
                return false;
            }
        });