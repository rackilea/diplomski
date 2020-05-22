String inputNum = myTextField.getText();
double actualNum = 0.0;
try {
  actualNum = Double.parseDouble(inputNum);  
} catch (NumberFormatException ne){
    // Prompt User
}