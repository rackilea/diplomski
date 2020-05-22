public void openDialog(LatLng coords) {
    //... your code without changes
    bt_da.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick(View v) {
            counter=1;
            Intent intent = new Intent(MapsActivity.this, MainActivity.class);
            // pass coords instead of latlngNew:
            intent.putExtra("markerLat", coords.latitude);
            intent.putExtra("markerLong", coords.longitude);
            startActivity(intent);

        }
    });
}