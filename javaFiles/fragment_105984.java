..
mButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             final String mNewPassword = mNewPasswordField.getText().toString();
             final String mConfirmPassword = mConfirmPasswordField.getText().toString();

            if (!(mNewPassword.equals(mConfirmPassword))) {