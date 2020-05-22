if(draggingcircle)
{
  g.drawString("Dragging circle = " + draggingcircle, 50, 110);
  circle.setCenterX( gc.getInput().getMouseX() );
  circle.setCenterY( gc.getInput().getMouseY() );
}