private Coordinates getModifiedCoordinates(MotionEvent event) {
    boolean shouldBeModified = <the conditions you are checking for>;
    if(shouldBeModified)
         return new Coordinates(modified_x,modified_y);
    else
         return new Coordinates(event.getX(), event.getY());
}