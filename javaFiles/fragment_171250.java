tf.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
           if(tf.hasFocus()) {                
                String strTempFval = tf.getText().toString();
                if (strTempFval.isEmpty()) {
                    tc.setText(null);
                } else {
                    double tempFval = Double.parseDouble(strTempFval);
                    double ftocval = toC(tempFval);
                    String resultC = String.valueOf(ftocval);
                    tc.setText(resultC);
                }
           }
        }
    });
}