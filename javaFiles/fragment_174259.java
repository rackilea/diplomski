public boolean numericalUserInput(String userInput){

    try {
        Double.parseDouble(userInput);
    }
    catch(NumberFormatException notANumber){
        JOptionPane.showMessageDialog(null, "You entered " + userInput + " but you should only enter numbers, please try again.");
        userEntryTextField.setText("");
        return false;
    }
    return true;
}