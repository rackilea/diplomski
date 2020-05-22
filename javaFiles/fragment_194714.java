public void actionPerformed(ActionEvent e) {
    if (e.getComponent() == myDealerComponent()) {
    // I do this if statement because the actionPerformed can treat more components
        if (! running) {
            timer.start();
            runnig = true;
        }
        // Hit a card if it must be hitted
        switch (getJBTable(JB.total, JB.aces > 0)) {
          case 0:
              JB.hit();
              break;
          case 1:
              break done;
          case 2:
              JB.hit();
              JB.bet *= 2;
              break done;
        }
        if (JB.total >= 21) { // In this case we don't need count the number of times, only check the JB.total 21 reached
            timer.stop()
            running = false;
        }

    }
}