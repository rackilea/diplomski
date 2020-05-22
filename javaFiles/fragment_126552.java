ActionListener al = new ActionListener() {
  int iterations = 0;
  public void actionPerformed(ActionEvent ae) {
           if (iterations == 25) {
             timer.stop();
           }
           interations++;
           System.out.println("Working on bottom!");
            newX = Ellipse.x + 10;
            Ellipse.x = newX;
            newY = Ellipse.y + 10;
            Ellipse.y = newY;   
            repaint();                  
  }
};

final timer = new javax.swing.Timer(delay, al);
timer.start();