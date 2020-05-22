browse.addActionListener(new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent e) {
        if (simpleModel != null) {
           simpleModel.setFileText(fileTxt.getText());
        }
     }
  });