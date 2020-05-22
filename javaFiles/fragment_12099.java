public void actionPerformed(ActionEvent evt) 
{
    if (evt.getSource() == calc )
    { 
       if(validate()){
        amount = inField.getText();
        number = ( Float.parseFloat( amount ) );
        number = (15*number/100);

        output.setText ( Float.toString ( number ) + '$' );

        }
     else{
   // show message for inter valid number or any other
       }
     }

    else if (evt.getSource() == clear )
    {
        output.setText("$");
        inField.setText("");
    }
 }
  boolean validate(){  

   try{
    amount = inField.getText();
        number = ( Float.parseFloat( amount ) );
      return true;

  }
   catch(Exception e){
   return false;

 }




 }