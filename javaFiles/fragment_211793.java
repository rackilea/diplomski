NdefRecord[] records = new NdefRecord[3];
records[0] = NdefRecord.createUri("http://stackoverflow.com/");
records[1] = NdefRecord.createMime("text/plain", "content".getBytes());
records[2] = NdefRecord.createExternal("com.stackoverflow", "nfc", "content".getBytes());

NdefMessage message = new NdefMessage(records);