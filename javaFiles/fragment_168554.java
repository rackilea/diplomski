name1.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
        @Override
        public void afterTextChanged(Editable s) {
            for (int i = 0; i < s.length(); i++) {
                if(name1.getText().toString().length()>16)
                {
                    register.setClickable(false);
                    mistakeusername.setErrorEnabled(true);
                    mistakeusername.setError("You cant insert more then 16 characters");
                }else {
                    if (!(Character.isLetterOrDigit(s.charAt(i))||Character.toString(s.charAt(i)).equals("_")))
                    {
                        register.setClickable(false);
                        mistakeusername.setErrorEnabled(true);
                        mistakeusername.setError("Only allowed Digit, Number or '_'");
                        break;
                    }else{
                        register.setClickable(true);
                        mistakeusername.setErrorEnabled(false);
                        mistakeusername.setError("");
                    }
                }
            }
        }
     });