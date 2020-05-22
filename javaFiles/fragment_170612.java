@Override
protected void onNewIntent(Intent intent) {
    Tag nfcTag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
    if (nfcTag == null) {
        Log.w(LOG_TAG, "Unable to obtain NFC tag from intent!");
    } else {
        String tagId = bytesToHex(nfcTag.getId());
        ...
    }