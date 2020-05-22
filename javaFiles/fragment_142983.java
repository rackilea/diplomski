private Bitmap createPolylineBitmap() {
    Bitmap bitmap = Bitmap.createBitmap(mapFragment.getView().getWidth(), mapFragment.getView().getHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);

    Paint paint = new Paint();
    paint.setColor(ContextCompat.getColor(this, R.color.purple));
    paint.setStrokeWidth(10);
    paint.setDither(true);
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeJoin(Paint.Join.ROUND);
    paint.setStrokeCap(Paint.Cap.ROUND);
    paint.setAntiAlias(true);

    for (int i = 0; i < coordinates.size(); i++) {
        LatLng latLng1 = new LatLng(coordinates.get(i).latitude, coordinates.get(i).longitude);
        LatLng latLng2 = new LatLng(coordinates.get(i + 1).latitude, coordinatest.get(i + 1).longitude);
        canvas.drawLine((LatLngToPoint(latLng1).x), ((LatLngToPoint(latLng1).y)), (LatLngToPoint(latLng2).x), (LatLngToPoint(latLng2).y), paint);
    }

    return bitmap;
}

private Point LatLngToPoint(LatLng coordinate) {
    Projection projection = googleMap.getProjection();

    return projection.toScreenLocation(coordinate);
}