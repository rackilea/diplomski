public void mousePressed(MouseEvent event)
 {
    //Get x and y
    int x = event.getX();
    int y = event.getY();
    //set selected to null
    selected = null;
    //if a fruit contains x, y then selected is assigned that fruit
    for( Fruit m : fruits)
    {
       if(m.contains(x,y))
       {
         selected = m;
         // position is set in mouseDrag
       }
    }