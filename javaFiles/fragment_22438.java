public static Polygon drawRectangle(Context context,
                                    GoogleMap googleMap,
                                    LatLng latLng1,
                                    LatLng latLng2,
                                    int strokeWidth,
                                    int strokeColor,
                                    int fillColor) {
    Polygon polygon = null;

    if (context != null && googleMap != null && latLng1 != null && latLng2 != null) {
        // create the other 2 points of the rectangle
        LatLng latLng3 = new LatLng(latLng1.latitude, latLng2.longitude);
        LatLng latLng4 = new LatLng(latLng2.latitude, latLng1.longitude);

        googleMap.addPolygon(new PolygonOptions()
                .add(latLng1)
                .add(latLng3)
                .add(latLng2)
                .add(latLng4)
                .strokeWidth(strokeWidth)
                .strokeColor(strokeColor)
                .fillColor(fillColor));
    }

    return polygon;
}