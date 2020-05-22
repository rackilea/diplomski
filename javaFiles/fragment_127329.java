public static Context context;
onCreate(..) {
    context = getApplicationContext(); // it will be used in Itemized Overlay
     latitude = getIntent().getDoubleExtra("lat", 0);//get the lat & lng
     longitude = getIntent().getDoubleExtra("lng", 0);
}


public void showMap() {

    // TODO Auto-generated method stub
    try {

        geoPoint = new GeoPoint((int)(latitude * 1E6),(int)(longitude * 1E6));

        mapview = (MapView)findViewById(R.id.mapview);

        mapControll= mapview.getController();

        mapview.setBuiltInZoomControls(true);

        mapview.setStreetView(true);

        mapview.setTraffic(true);

        mapControll.setZoom(16);

        mapControll.animateTo(geoPoint);



        userPic = this.getResources().getDrawable(your pic....);

        userPicOverlay = new MyItemizedOverlay(userPic);

        OverlayItem overlayItem = new OverlayItem(geoPoint, "", null);

        userPicOverlay.addOverlay(overlayItem);

        mapview.getOverlays().add(userPicOverlay);
        //Added symbols will be displayed when map is redrawn so force redraw now

        mapview.postInvalidate();

    } catch (Exception e) {

        // TODO: handle exception

        e.printStackTrace();

    }

}