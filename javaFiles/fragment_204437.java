public ButtonPanel(GUIApp d) {
 ActionListener listener = new ActionListener(){
  @Override
  public void actionPerformed(ActionEvent event) {
   Object location = event.getSource();
   if (btnRed.equals(location)) {
    d.setOval(1);
   } else if (btnGreen.equals(location)) {
    d.setOval(2);
   } else if (btnBlue.equals(location)) {
    d.setOval(3);
   }
  }
 };
 // The rest of your constructor code here ...
}