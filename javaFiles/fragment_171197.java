public void onPause() {
    super.onPause();
    nfcadapter.disableForegroundDispatch(this);
}

public void onResume() {
    super.onResume();
    nfcadapter.enableForegroundDispatch(this, pendingIntent, intentFiltersArray, techListsArray);
}

public void onNewIntent(Intent intent) {
    Tag tagFromIntent = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
    //do something with tagFromIntent
}