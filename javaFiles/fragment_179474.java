final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );
final ImageView gpsImg = (ImageView) findViewById(R.id.gpsstatus);
if (manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
    gpsImg.setImageResource(R.drawable.ok);
} else {
    gpsImg.setImageResource(R.drawable.notok);
}