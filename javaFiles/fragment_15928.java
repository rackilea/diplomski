private void showPopUp3() {
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle("Enter PU Builder");
        LayoutInflater inflater = getLayoutInflater();
        View checkboxLayout = inflater.inflate(R.layout.popuplayout, null);

        getInput = (EditText)  checkboxLayout.findViewById(R.id.editText1); //MISTAKE
        getInput2 = (EditText)  checkboxLayout.findViewById(R.id.editText2); //MISTAKE
        getInput.setText(showPopUpButton.getText()); //New to keep the text in the editText when done is pressed
        getInput2.setText(getInput2.getText()); //New test

        // here set the my value to edit text  , note firs time will be empty 
        getInput.setText(myValue)