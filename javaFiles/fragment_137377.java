@Override
public boolean onMarkerClick(Marker marker) {

    if (marker.equals(marker))
    {
        Intent intent = new Intent(MapsActivity.this, CameraView.class) ;

        startActivity(intent);

    }
    return false;

}