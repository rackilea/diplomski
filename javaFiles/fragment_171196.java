IntentFilter[] intentFiltersArray = null;

Write below code in onCreate() method:

IntentFilter ndef = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
        try {
            ndef.addDataType("*/*");    /* YOU CAN TYPE HERE EITHER android.nfc.action.NDEF_DISCOVERED or
            android.nfc.action.ACTION_TAG_DISCOVERED */
        }
        catch (IntentFilter.MalformedMimeTypeException e) {
            throw new RuntimeException("fail", e);
        }
        IntentFilter[] intentFiltersArray = new IntentFilter[] {ndef, };