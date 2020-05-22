public String function(Point p1, Point p2) {
    String formula;
    Point p3; //Gradient
    p3.x=p2.x-p1.x;
    p3.y=p2.y-p1.y;
    double gradient=p3.y/p3.x; //Gradient per x
    double add=p1.y-gradient*p1.x;
    if (add != 0) {
        formula=Double.toString(gradient)+"x+"+Double.toString(add);
    }
    else {
        formula=Double.toString(gradient)+"x";
    }
    return formula;
}