projection.toPixels(geoArrList.get(i), pointToTest);

Point p1 = new Point();
for(int i=0; i<geoArrList.size(); i++){
    projection.toPixels(geoArrList.get(i), p1);
    int squareDistance = ((pointToTest.x - p1.x) * (pointToTest.x - p1.x) +
        (pointToTest.y - p1.y) * (pointToTest.y - p1.y));
    if(squareDistance  < THRESOULD){
        //same point
    }
}