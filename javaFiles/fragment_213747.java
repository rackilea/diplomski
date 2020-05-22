public void viewBar() {

  progressbar.setStringPainted(true);
  progressbar.setValue(0);

  int timerDelay = 10;
  new javax.swing.Timer(timerDelay , new ActionListener() {
     private int index = 0;
     private int maxIndex = 100;
     public void actionPerformed(ActionEvent e) {
        if (index < maxIndex) {
           progressbar.setValue(index);
           index++;
        } else {
           progressbar.setValue(maxIndex);
           ((javax.swing.Timer)e.getSource()).stop(); // stop the timer
        }
     }
  }).start();

  progressbar.setValue(progressbar.getMinimum());
}