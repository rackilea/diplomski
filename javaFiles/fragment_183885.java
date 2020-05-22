//this looks odd/suspicious to me too!
   String inp = event.toString(); //???!!! this is input in a JTextField
   /* rather something like 
    *  if(event.getSource() instanceof JTextField){
    *      inp = ((JTextField)event.getSource()).getText();
    *  }
    */
   if(event.getSource() == clear) { //clear is a button
     //clear.setEnabled(true); 
     txtArea.setText(""); //I've tried selectAll(), replaceSelection()

   } else if(inp.contains("sad") || inp.contains("lonely")) { 
       txtArea.setText(response1);

   } else if(inp.contains("")) { //??? always true!! rather: inp.equals("") or inp.isEmpty() ...
       txtArea.setText(response2);
   }