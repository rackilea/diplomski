public void mousePressed(MouseEvent e)
{ 
   Robot robot = new Robot();
   Color clickedColor = robot.getPixelColor(e.getX(),e.getY());
   doSomething(clickedColor);
}