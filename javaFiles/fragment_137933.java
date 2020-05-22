Bundle b = new Bundle();
Intent that = new Intent(this, GoogleMapSearchActivity.class);
that.putExtras(b); // formerly that.putExtra("bundle", b);
startActivity(that);

Bundle bund;
Intent activity = getIntent();
bund = activity.getExtras(); // fomerly bund = activity.getBundleExtra("bundle");