@Override
protected void beforeMapaGPS(Form f) {
    MapComponent mapComponent= new MapComponent();
    double latitude=-41.169782;
    double longitude =-71.444885;

    Coord lastLocation = new Coord(latitude, longitude);
    mapComponent.zoomTo(lastLocation, 15);

    f.setLayout(new BorderLayout());
    f.addComponent(BorderLayout.CENTER, mapComponent);
}