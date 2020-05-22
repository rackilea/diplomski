public void actionPerformed(ActionEvent e) {

  try{
    String text = inputField.getText();
    System.out.println(text);
    outputLabel.setText("String length = " + text.length());
    if (text.length()==0)
      throw new NullPointerException();
    }
    catch(NullPointerException e1)
    {
      e1.printStackTrace();
    }
 }