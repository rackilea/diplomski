private void DrawPolygon(List<LatLng> array) {

int length = array.size();
// Store a data object with the polygon, 
// used here to indicate an arbitrary type.
PolygonOptions poly = new PolygonOptions();

for(int i = 0; i < length; i++){
    if(array.get(i).latitude != null &&
        array.get(i).longitude != null){
        LatLng latLong = new LatLng(array.get(i).latitude,       
                              array.get(i).longitude);
        poly.add(latLong);
    }   
}