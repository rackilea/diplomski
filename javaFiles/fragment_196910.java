@Override
 public void actionPerformed(ActionEvent e) {
    // get the text
    JTextComponent textComp = (JTextComponent) e.getSource();
    String text = textComp.getText().trim(); // trim it to rid it of white space

    if (text.isEmpty()) {
       // code to show a profile 
       return;  // to exit this method
    } 

    // if we're here, the field is not empty

    if (!text.matches("[0-9]+")) {
        // show a warning message here
    } else {
      // numeric only data present
      // do action for this state

   }
   // clear the text
   textComp.setText("");
}