PolygonOptions polygonOptions;

@Override
protected void onPreExecute() {
   if (googleMap == null) {
       googleMap = ((SupportMapFragment) fragmentActivity.getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
   }
}

....

 @Override
protected void onPostExecute() {
    Polygon polygon = googleMap.addPolygon(polygonOptions.strokeColor(Color.TRANSPARENT).fillColor(Color.RED));
}