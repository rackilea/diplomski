ArrayList<LatLng> coordinates; // your ArrayList with marker's coordinates
BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.icon2));
...
int size = coordinates.size();  
for (int i = 0; i < size; ++i) {
    LatLng coordinate = coordinates.get(i);

    googleMap.addMarker(new MarkerOptions()
       .position(coordinate)
       .icon(icon)
       .title("Title" + (i + 1))
       .snippet("Snippet" + (i + 1))
       .anchor(0.5f, 0.5f));
}