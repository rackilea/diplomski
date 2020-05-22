protected void addOverlay(PointOfInterest pointOfInterest) {

    PointOfInterest pointOfInterest2 = new PointOfInterest(pointOfInterest.title,pointOfInterest.title,pointOfInterest.type,pointOfInterest.point,pointOfInterest.privateField);
    mapOverlays.add(pointOfInterest2);
    setLastFocusedIndex(-1);
    Log.d("Add Overlay", pointOfInterest2.getSnippet());
    populate();

}