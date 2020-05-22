NdefMessage ndefMsg = new NdefMessage(new NdefRecord[] { myImageRecord });

Tag tag = ...;
Ndef ndefTag = Ndef.get(tag);
if (ndefTag != null) {
    ndefTag.connect();
    ndefTag.writeNdefMessage(ndefMsg);
    ndefTag.close();
} else {
    NdefFormatable ndefFormatable = NdefFormatable.get(tag);
    if (ndefFormatable != null) {
        ndefFormatable.connect();
        ndefFormatable.format(ndefMsg);
        ndefFormatable.close();
    }
}