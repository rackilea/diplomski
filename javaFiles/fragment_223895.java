HelloItemizedOverlay iOverlay1 = new ItemizedOverlay(R.drawable.pointAimage, MainActivity.this);
HelloItemizedOverlay iOverlay2 = new ItemizedOverlay(R.drawable.pointBimage, MainActivity.this);
GeoPoint pointA = new GeoPoint(37337748, -12188670);
GeoPoint pointB = new GeoPoint(37336453, -12188498);
OverlayItem overlayItemA = new OverlayItem(pointA, "Title", "Body");
OverlayItem overlayItemB = new OverlayItem(pointB, "Title", "Body");
iOverlay1.addOverlay(overlayItemA);
iOverlay2.addOverlay(overlayItemB);