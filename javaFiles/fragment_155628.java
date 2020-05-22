public static void main(String[] args){
  JFrame f=new JFrame();            // create a window object in which to place a component
  f.add(new JLabel(){               // create a component within the window
    public void paint(Graphics g){  // override paint on this component to get a drawing area
      super.paint(g);               // call the default drawing command to draw background
      draw(g, 1,2,3,4);             // call your drawing routine
    }
  });
  f.pack();                         // make frame big enough for the label
  f.setVisible(true);               // show the frame, with its contents. 
  // Only after this is your routine actually called to do the drawing.
} // the main program now exits, but Java's event thread continues to run in the background, 
// drawing your object until the window is closed.