@Override
public boolean onMarkerClick(Marker marker) {
    int markerLat = marker.getPosition().latitude;
    int markerLng = marker.getPosition().longitude;
    for (int i = 0; i < lat2.length; i++) {
        if (markerLat == lat2[i] && markerLng == lon2[j]) {
            String title = marker.getTitle();
            Log.e("TAG", " " + title);               
        }
    }
    return true;
}