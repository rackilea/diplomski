public boolean onTap(GeoPoint gptLocation, MapView mapMap) {

    String strCoordinates = String.format("%f,%f", gptCoordinates.getLatitudeE6() / 1E6, gptCoordinates.getLongitudeE6() / 1E6);
    String strUri = String.format("geo:%s?z=14", strCoordinates);
    Intent ittMap = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
    ittMap.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    this.ctxContext.startActivity(ittMap);
    return false;

}