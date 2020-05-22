final GoogleMap map = ((SupportMapFragment)  getSupportFragmentManager().findFragmentById(R.id.map)).getMap();  
...
Display display = getWindowManager().getDefaultDisplay();
int width = display.getWidth();
int height = display.getHeight();
Point point = new Point(width / 2, height / 2);
LatLng latLng = map.getProjection().fromScreenLocation(point);

latitudeTV.setText(String.valueOf(latLng));