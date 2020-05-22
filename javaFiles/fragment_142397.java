void resolveIntent(Intent intent) {
    Context context = getApplicationContext();
    int duration = Toast.LENGTH_LONG;
    // processIntent(intent);

    // 1) Parse the intent and get the action that triggered this intent
    String action = intent.getAction();
    // 2) Check if it was triggered by a tag discovered interruption.
    if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)) {
        // 3) Get an instance of the TAG from the NfcAdapter

        try {

            tagFromIntent = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            byte[] extraID = tagFromIntent.getId();
            if (extraID == null) {
                Log.e("TAG","NFC Tag ID Is Null");

            } else {

                StringBuilder sb = new StringBuilder();
                for (byte b : extraID) {
                    sb.append(String.format("%02X", b));
                }
                ;

                String tagID = sb.toString();
                // Log.e("nfc ID", tagID);

                // Begin Serial No
                String hexdump = new String();
                for (int i = 0; i < extraID.length; i++) {
                    String x = Integer
                            .toHexString(((int) extraID[i] & 0xff));

                    if (x.length() == 1) {
                        x = '0' + x;
                    }
                    hexdump += x + ':';
                }

                hexdump = hexdump != null ? hexdump.substring(0,
                        hexdump.length() - 1) : "";
                txtSLNo.setText(hexdump.toUpperCase());
            }

            // Toast toast = Toast.makeText(context, hexdump, duration);
            // toast.show();

            Parcelable[] rawMsgs = intent
                    .getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
            if (rawMsgs == null) {


                Log.e("TAG","NFC Tag Information Is Blank!");
            } else {
                // only one message sent during the beam
                NdefMessage msg = (NdefMessage) rawMsgs[0];
                // record 0 contains the MIME type, record 1 is the AAR, if
                // present
                byte[] payload = msg.getRecords()[0].getPayload();
                String textEncoding = ((payload[0] & 0200) == 0) ? "UTF-8"
                        : "UTF-16";

                // Get the Language Code
                int languageCodeLength = payload[0] & 0077;

                String languageCode = new String(payload, 1,
                        languageCodeLength, "US-ASCII");
                String text = new String(payload, languageCodeLength + 1,
                        payload.length - languageCodeLength - 1,
                        textEncoding);

               Log.e("TAG",text);

            }

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Get the Text

        // textView1.setText(new String(msg.getRecords()[0].getPayload()));

    }
    ;
}// End of method