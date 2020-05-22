int[] xPoly = new int[pointArrayX.size()]; //create an array and set its size
int[] yPoly = new int[pointArrayY.size()]; //create an array and set its size

//loop i added to copy the elements from your method arguments to the new arrays
for(int i = 0; i < xPoly.size(); i++) {
    xPoly[i] = pointArrayX.get(i);
    yPoly[i] = pointArrayY.get(i);
}

Polygon poly = new Polygon(xPoly,yPoly,xPoly.length); //use the created array