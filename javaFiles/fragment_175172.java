private EditText passwordEditText;
            private TextInputPassword textInputPassword;
         @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                /* Initializing views */
                passwordEditText = (EditText) findViewById(R.id.password);
                /* Set Text Watcher listener */
                passwordEditText.addTextChangedListener(passwordWatcher);
                textInputPassword = (TextInputLayout) 
                findViewById(R.id.text_input_password);
        }

        private final TextWatcher passwordWatcher = new TextWatcher() {
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                public void afterTextChanged(Editable s) {
                    if (s.length() == 0) {
                        textInputPassword.setErrorEnabled(true);
                         textInputPassword.setError("Password Required");
                    } else{
                       textInputPassword.setErrorEnabled(false);
                        textView.setText("You have entered : " + passwordEditText.getText());
                    }
                }
            };