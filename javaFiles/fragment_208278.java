public class rebuiltgui extends JApplet {

  public void init() {

    JPanel jpan = new CustomJPan();     
  }
}

class CustomJPan extends  JPanel {

  public CustomJPan()  {
      super();
      setBackground( Color.red );
  }

  public void changeColour() {

    // Change colour to blue here
  }
}