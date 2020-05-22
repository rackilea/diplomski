private NfcAdapter getAdapter() {
   if (mAdapter == null) {
       NfcManager manager = (NfcManager) getSystemServive(NFC_SERVICE);
       mAdapter = manager.getDefaultAdapter(this);
   }
   return mAdapter;
}

@Override
protected void onResume() {
    super.onResume();
    getAdapter().enableForegroundDispatch(this, mPendingIntent, mFilters, null);
}