public void plusButton(View view) {
            plus = true;
            first = Integer.valueOf(editText.getText().toString());
            editText.setText("");
            minus=false;

        }

        public void minusButton(View view) {
            minus = true;
            first = Integer.valueOf(editText.getText().toString());
            editText.setText("");
            plus = false;
        }