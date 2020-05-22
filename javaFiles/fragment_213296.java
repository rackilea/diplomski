@Override
public void onMapReady(GoogleMap googleMap) {
    this.googleMap = googleMap;

    if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 2);
    }

    this.googleMap.setOnMapClickListener(this);

    mapDisplayPosition();
}