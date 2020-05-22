JTextField nameP;

    private class createListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
        nameP = new JTextField();
      }
    }

    private class playerListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
        String name = nameP.getText();
    }