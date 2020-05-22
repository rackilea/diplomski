private void onNewNfcTag(Intent intent) {
    if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())
            || NfcAdapter.ACTION_TECH_DISCOVERED.equals(intent.getAction()) 
            || NfcAdapter.ACTION_TAG_DISCOVERED.equals(intent.getAction())) {
        Tag iTag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        mTextView.setText(TagReader.readTag(iTag, intent));
    }
}