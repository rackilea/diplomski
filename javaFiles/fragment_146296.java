public void actionPerformed(java.awt.event.ActionEvent arg0) {
     currentCirclesToDraw = 0;  // this is key -- reset the index used to control how many circles to draw
     if (ellipseList.size() < MAX_CIRCLE_INDEX) {
        double x = (ellipseList.size()) * CIRCLE_WIDTH / Math.pow(2, 0.5);
        double y = x;
        double w = CIRCLE_WIDTH;
        double h = CIRCLE_WIDTH;
        ellipseList.add(new Ellipse2D.Double(x, y, w, h));
     }
     repaint(); // clear image
     new Timer(TIMER_DELAY, new TimerListener()).start();
  };