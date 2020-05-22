markers = new  MarkerClass(); //<--- ADD THIS
markers.setComSci(map); //<-- Call using this statement

public class MarkerClass extends MapActivity{
String itemtype;
LatLng coordinates;
String name;
GoogleMap map;

public void setComSci(GoogleMap map){
    this.map = map;
    name = "Computer Science Building";
    itemtype = "Building";
    coordinates= new LatLng(-33.956812, 18.461021);
    Marker comscimark = map.addMarker(new MarkerOptions()
    .position(coordinates)
    .draggable(true)
    .title(name));
  } 
}