private void startLandNav(Bundle b) {
    Intent intent = new Intent(this, LandNav.class);
    intent.putExtras(b);
    startActivityForResult(intent, 0);
}

private OnClickListener landNavButtonListener = new OnClickListener() {
    @Override
    public void onClick(View arg0) {
        Bundle bundle = new Bundle();
        bundle.putDouble("longKey", longid);
        bundle.putDouble("latKey", latd);
        longid = Double.parseDouble(longi.getText().toString());
        latd = Double.parseDouble(lati.getText().toString());
        startLandNav(bundle);
    }
};