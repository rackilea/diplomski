MouseAdapter myMouseAdapter = new MouseAdapter() {
     public void mousePressed(MouseEvent evt) {
        moveIt(evt);
        count = count + 1;
     }

     @Override
     public void mouseDragged(MouseEvent evt) {
        moveIt(evt);
     }
  };
  addMouseListener(myMouseAdapter);
  addMouseMotionListener(myMouseAdapter);
}