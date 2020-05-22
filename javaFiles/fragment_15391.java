public void actionPerformed(ActionEvent e) {
  final Object source = evt.getSource();

  if (source == buttons[treasureLocation]) {
     buttons[treasureLocation].setIcon(image1);
     label1.setText("You've found me Treasure!");

     Timer timer = new Timer(TIMER_DELAY, new ActionListener() {
       public void actionPerformed(ActionEvent evt) {
         // reset GUI including the JButton's icon
       }
     });
     timer.setRepeats(false);
     timer.start();
  }  
}