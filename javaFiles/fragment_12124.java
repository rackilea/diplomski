import android.nfc.NfcAdapter;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    NfcAdapter adapter = NfcAdapter.getDefaultAdapter(this);
    adapter.enableReaderMode(this, null, NfcAdapter.STATE_OFF, null);
}