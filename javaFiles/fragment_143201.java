TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
        @Override
        public void afterTextChanged(Editable s) {
            btnRegister.setEnabled(!txtEmployeeName.getText().toString().isEmpty() && !txtEmployeeID.getText().toString().isEmpty()&&URLUtil.isValidUrl(txtServerName.getText().toString()));
        }
    };