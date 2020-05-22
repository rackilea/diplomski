@Override
public boolean onDrag(View v, DragEvent event) {
    int action = event.getAction();
    float xCoord;
    float yCoord;
    if(action == DragEvent.ACTION_DRAG_LOCATION) {
        xCoord = event.getX();
        yCoord = event.getY();
    }
    return event.getResult();       //returns true for valid drop or false for invalid drop
}