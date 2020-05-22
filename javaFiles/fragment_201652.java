// In the Menu class
private class ButtonListener implements ActionListener{
  @Override
  public void actionPerformed(ActionEvent e){
    if(((JButton) e.getSource()).getName().equals(nameOfButton)){
      //do something
    }
   else if(((JButton)e.getSource()).getName().equals(nameOfDifferentButton)){
      //do something different
    }
  }
}