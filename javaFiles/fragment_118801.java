int delayTime = 2 * 1000;
  javax.swing.Timer myTimer = new Timer(delayTime, new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent e) {
        // TODO: put in the code you want called in xxx mSecs.
     }
  });
  myTimer.setRepeats(false);
  myTimer.start();