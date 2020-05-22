public class MyPanel extends JPanel {

  public ArrayList<Circle> circles = new ArrayList<Circle>(); 

  public void paintComponent(Graphics g) {

    Circle c = new Circle(xstart, ystart);   //create a new circle
    circles.add(c);
    if (drawing){  
        for(int k=0; k<circles.size(); k++){
            circles.get(k).draw(g);
        }
    }           // draw the circle
  }