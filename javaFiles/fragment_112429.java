JRadioButton b1 = new JRadioButton("");
 b1.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent e) {
     if ("disable".equals(e.getActionCommand())) {
      b1.setEnabled(true);
       } else {
        b1.setEnabled(false);
       }
    }
    });