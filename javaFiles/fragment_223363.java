public void createCircles(int x, int y, int rad, Color parentColor){
    Circle myCircle = new Circle(x, y, rad, parentColor);
    ...
    if(!(rad<1)){
        ...
        Color myColor = parentColor.darker();
        createCircles(x - (2*rad), y, rad/3, myColor);
        createCircles(x, y, rad/3, myColor);
        createCircles(x + (2*rad), y, rad/3, myColor);
    }
}