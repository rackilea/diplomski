int num1,num2;

    if(firstNumEditText.getText().toString().isEmpty()) {
         // is empty
         return;
    } else {
         // is not empty
        num1 = Integer.parseInt(firstNumEditText.getText().toString());
    }

    if(secondEditText.getText().toString().isEmpty()) {
         // is empty
         return;
    } else {
         //  is not empty
       num2 = Integer.parseInt(secondEditText.getText().toString());
    }

    resultTextView.setText(String.valueOf(num1+num2);