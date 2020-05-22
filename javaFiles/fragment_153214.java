jframe.addMouseMotionListener(new MouseMotionListener() {
@Override
public void mouseDragged(MouseEvent e) {
    xDrag = e.getX();
    yDrag = e.getY();

    JFrame sFrame = (JFrame) e.getSource();
    sFrame.setLocation(sFrame.getLocation().x+xDrag-xPress, 
    sFrame.getLocation().y+yDrag-yPress);
 }

 @Override
 public void mouseMoved(MouseEvent e) {
     xPress = e.getX();
     yPress = e.getY();
  }
});