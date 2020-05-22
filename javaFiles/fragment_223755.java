JButton showButton = new JButton("AlwaysOn");
showButton.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {
     String currentText = showButton.getText();
     if("AlwaysOn".equals(currentText)){
          showButton.setText("REST");
     }else{
          showButton.setText("AlwaysOn");
      }
  }
});