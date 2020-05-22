int i = 1; 
//loop triggers no errors, and does execute when running
while(iter.hasNext()){
    x = myPolygon.get(i).getX();
    y = myPolygon.get(i).getY();
    pen.move(x, y);
    i++;
}