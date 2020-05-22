if (mTwoPane) {
   ...
}
else {
   Intent intent = new Intent(this, mWC[position].activityClass);

   String station = mWC[position].station;
   intent.putExtra(WCBankActivity.EXTRA_MESSAGE, station);

   startActivity(intent);
}