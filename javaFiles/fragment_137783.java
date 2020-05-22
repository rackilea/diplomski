int timerDelay = 1000;
new Timer(timerDelay, new ActionListener(){
  int count = 0;

  @Override
  public void actionPerformed(ActionEvent e) {
    if (count < IMAGE_COUNT) {
      someLabel.setIcon(icons[count]);
      count++;
    } else {
      // stop the timer
      ((Timer)e.getSource()).stop();
    }

  }
}).start();