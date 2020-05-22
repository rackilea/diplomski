b1.addActionListener(new ActionListener() {
  public void actionPerformed (ActionEvent e)
  {

    clicked++;

    if (clicked >= 5) {

      Object[] options = {
        "No, thanks",
        "Yes, please"
      };

      int response = JOptionPane.showOptionDialog(frame,
        "Would you like more math questions? ",
        "Math Questions",
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        options ,  
        options[1]);

      if (response == 1) 
        clicked = 0; //reset
      else
        System.exit(0);
    } 

  }
});