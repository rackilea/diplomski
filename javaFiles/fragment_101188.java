private EditText input_email,input_password;

    public boolean validate() {
                boolean valid = true;

                String email = input_email.getText().toString();
                String password = input_password.getText().toString();

                if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    input_email.setError("enter a valid email address");
                    valid = false;
                } else {
                    input_email.setError(null);
                }

                if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
                    input_password.setError("between 4 and 10 alphanumeric characters");
                    valid = false;
                } else {
                    input_password.setError(null);
                }

                return valid;
            }