public void onClick(View v) {
    // TODO Auto-generated method stub
    switch (v.getId()) {
    case R.id.ibMap:
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Procurando");
    mProgressDialog.setMessage("Localizando o dispositivo.");
    mProgressDialog.show();
    mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mGeoHandler);
        break;
    default:
    Toast.makeText(getBaseContext(), "Nothing yet.", Toast.LENGTH_SHORT).show();
    }
}

private class GeoLocationHandler implements LocationListener {

    public void onLocationChanged(Location location) {
    // TODO Auto-generated method stub
    mLocation = location;
    mHandler.sendEmptyMessage(0);
    }

}

private class MyHandler extends Handler {

@Override
public void dispatchMessage(Message msg) {
    mProgressDialog.dismiss();
    double lat = mLocation.getLatitude();
    double lng = mLocation.getLongitude();
    Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=" + lat + "," + lng + "&daddr=UFRJ,RJ"));
    startActivity(intent);
    super.dispatchMessage(msg);
}

}