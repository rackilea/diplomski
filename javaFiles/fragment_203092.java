@Override
public boolean onMarkerClick(Marker marker) {

    if (counter==0) {
        // pass marker coordinates here:
        openDialog(marker.getPosition());
    }
    else
    {
        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        counter--;
    }

    return false;
}