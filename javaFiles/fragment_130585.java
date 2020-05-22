String amtRentIn=amountRentText.getText();
boolean incorrect = true;
while(incorrect){
try{Double.parseDouble(amtRentIn);incorrect = false;}
catch(NumberFormatException nfe){
   amtRentIn=JOptionPane.showInputDialog("Invalid input. Please "+
           "enter your rent: ");
 }

}