A a = new A(this);
a.setOntouchListener(new View.OnTouchListener(){
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Coordinates coords = getModifiedCoordinates(event);
        //do something with the coordinates
    }
}