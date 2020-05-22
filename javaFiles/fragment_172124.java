public void getVisibleRegionGrids(final VisibleRegion region)
{
    int columns = 3;
    int rows    = 4;

    double mainTopLat  = region.latLngBounds.northeast.latitude;  // (c, d)
    double mainMaxLng  = region.latLngBounds.northeast.longitude;

    double mainBottomLat = region.latLngBounds.southwest.latitude;
    double mainMinLng = region.latLngBounds.southwest.longitude;

    double horizontalDiff = Math.abs ((mainMaxLng - mainMinLng ) / columns);  // 1
    double verticalDiff   = Math.abs (( mainTopLat - mainBottomLat) / rows);  // 1

    double topLat  = mainTopLat;  // (c, d)
    double rightLng  = mainMaxLng;

    for (int i = 0; i < rows; i++)
    {
        for (int x = 0; x < columns ; x++)
        {
            double currentTopLat = (topLat - (i * verticalDiff));
            double currentLeftLng = (topLng + (x * horizontalDiff));

            try
            {
                MarkerOptions markerOptions = new MarkerOptions()
                        .draggable(false)
                        .position(new LatLng(Double.valueOf(currentTopLat), Double.valueOf(currentLeftLng)));
                mMap.addMarker(markerOptions);

                if ((i==(rows-1))|| (x==columns-1){//add the lowerright marker only on the last line or column, avoid duplicated markers
                double currentBottomLat = currentTopLat - verticalDiff;
                double currentRightLng = currentLeftLng + horizontalDiff;
                markerOptions = new MarkerOptions()
                                .draggable(false)
                                .position(new LatLng(Double.valueOf(currentBottomLat), Double.valueOf(currentBottomLng)));
                    mMap.addMarker(markerOptions);
    }
            }catch (Exception e)
            {}
        }
    }
}