NdefRecord first = NdefRecord.createUri("http://stackoverflow.com/");
NdefRecord second = NdefRecord.createMime("text/plain", "content".getBytes());
NdefRecord third = NdefRecord.createExternal("com.stackoverflow", "nfc", "content".getBytes());
// and so on ...

NdefMessage message = new NdefMessage(first, second, third);