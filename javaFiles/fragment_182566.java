double minDistance = Double.MAX_VALUE;
convertedHotSpotGeomList = RetrieveHotSpotAsyncTask.convertedHotSpotGeom;
LatLng[] minPoints = new LatLng[2]; // save the minimum points
for(int i = 0; i < convertedHotSpotGeomList.size(); i++){
    LatLng point1 = new LatLng(convertedHotSpotGeomList.get(i).getY(),   convertedHotSpotGeomList.get(i).getX());                                 
    LatLng point2 = new LatLng(convertedHotSpotGeomList.get(++i).getY(), convertedHotSpotGeomList.get(++i).getX());
    distance = calculateHotSpot(point1, point2);
    Log.i("DIST", String.valueOf(distance));
    if(distance < minDistance){
        minDistance = distance;
        Log.i("MIN", String.valueOf(minDistance));
        minPoints[0] = point1;
        minPoints[1] = point2;
    }
}
// we finish all the comparison, so we draw the circles now 
if(minPoints[0]!=null && minPoints[1] !=null){
    CircleOptions circleOptions = new CircleOptions()
        .center(minPoints[0])
        .radius(1000)
        .fillColor(Color.argb(95, 178, 30, 37))
        .strokeColor(Color.TRANSPARENT);
    CircleOptions circleOptions1= new CircleOptions()
        .center(minPoints[1])
        .radius(1000)
        .fillColor(Color.argb(95, 88, 130, 37))
        .strokeColor(Color.TRANSPARENT);

    googleBasemap.addCircle(circleOptions);
    googleBasemap.addCircle(circleOptions1);
}