List<LatLng> route = new ArrayList<>();
route.add(new LatLng(29.751260, -95.373639));
route.add(new LatLng(29.752881, -95.374454));
route.add(new LatLng(29.755107, -95.374583));

//Adding markers
MarkerOptions currentMarker;
for(int i=0; i<route.size(); i++) {
    currentMarker = getMarkerFromPoint(route.get(i));
    mapView.addMarker(currentMarker);
    }