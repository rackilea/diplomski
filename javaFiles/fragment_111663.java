// Whilst setting up a view the create method will not have a 
    // reasonable value for edittext1 - or it will be your default
    String stringInput = (edittext1.getText().toString());
if (stringInput.isEmpty()) { 
    doubleInput = 0.0;    // Will always enter this line
} else {
    doubleInput = Double.parseDouble(edittext1.getText().toString());
}