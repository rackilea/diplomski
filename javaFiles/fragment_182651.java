mouseButton.addMouseMotionListener(new MouseMotionListener() {

     @Override
     public void mouseDragged(MouseEvent e) {
     }

     @Override
     public void mouseMoved(MouseEvent e) {
         progress.setValue(x += 2);
     }
});