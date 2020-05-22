// code not compiled nor tested. It was typed free-hand.
// so it was not meant to be copy, pasted and used, but rather to show you 
// the idea.
public void mouseClicked(MouseEvent e) {
  mouseX = e.getX();
  mouseY = e.getY();

  // don't use if (shot == false). Instead do:
  if (!shot) {
     Ink = 0;
  }

  // likewise, no need to use if (ready == true). Instead do:
  if (ready) {
    shot = true;   

    // turn off your ability to shoot here by setting a boolean.
    ableToShoot = false;
    // start a Swing Timer that does not repeat
    // in the Timer turn back on the ability to shoot by setting a boolean
    Timer swingTimer = new Timer(TIMER_DELAY_TIME, new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        // allow shots here
        ableToShoot = true;
      }
    });
    swingTimer.setRepeats(false);
    swingTimer.start();   
  }
}