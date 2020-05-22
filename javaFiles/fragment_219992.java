switch (view.getId()) {
     case R.id.btn2ndDigitBlack0: {
         EditText editText = ((EditText)findViewById(R.id.resistText))
         String oldString = editText.getText()
         if (oldString.length <= 1) {
            editText.setText(oldString + "0")
         } else {
             editText.setText(oldString.substring(0, 1) + "0")
         }
         }
     ...