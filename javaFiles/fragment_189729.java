int count = 0;
public void mousePressed(MouseEvent event)
    {
      if(count == 0){
        double x1 = rxPixel(event.getX());
        double y1 = ryPixel(event.getY()); 
        point1 = new Point2D.Double(x1, y1);
        count++;
      }
      if(count == 1){
        double x2 = rxPixel(event.getX());
        double y2 = ryPixel(event.getY()); 
        point2 = new Point2D.Double(x2, y2);
        repaint();
      }
    }