//Find the max value for scaling purposes
double max = Double.MIN_VALUE;
double min = Double.MAX_VALUE
for(double i : array){
    if(i > max) max = i;
    if(i < min) min = i;
}


for(double i : array){
    //Replace 100 with a variable for how long the line is!
    double scaled = ((i-min)/(max-min)) * 100; 

    Ellipse.Double circle = new EllipseDouble(width, height, scaled, 0);

    g2d.draw(circle)
}