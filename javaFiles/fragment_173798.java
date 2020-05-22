clickButton.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
       // Just to make sure there is something in the input
       if(inputValue.getText() == null || inputValue.getText().length()<=0) {
           inputValue.setError("Must input value");
       } else {
            // Put in your formula

            // Get your values for your spinners using their index in the list
            // The index starts at zero, so adding one and
            // multiplying by 2 gives you your numbers
            int spinnerAValue = (spinnerA.getSelectedItemPosition()+1)*2;
            int spinnerBValue = (spinnerA.getSelectedItemPosition()+1)*2;

            // Convert the input to a number (use double if there are decimals)
            double input = Double.parseDouble(inputValue.getText());

            double result = input * (spinnerAValue/spinnerBValue);

            // Set the output TextView to the result, converting it to a string
            outputValue.setText(Double.toString(result));

        }
   }
}