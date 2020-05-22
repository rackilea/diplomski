List <LatLng> pathPoints = PolyUtil.decode("lvzsEhgvuI~c@HbJr@lJ`@|MrDfJlE~GxCdEvQ~IhCfDh@bIi@dGwB|D{GL{VqBqGcHcEeNGqGpGmHnQ");
for (LatLng point : pathPoints) {
    Log.d(TAG, "" + point.latitude + "," + point.longitude);
}
PolylineOptions polylineOptions = new PolylineOptions()
        .addAll(pathPoints)
        .color(Color.RED)
        .width(20);