List<MapView> mapViews = new ArrayList<>();
for (int i = 1; i <= 6; i++) {
    MapView mapView = new MapView(getActivity(), i);
    initialMapView(mapView);
    mapViews.add(mapView);
}