byte[] ndefMessage = new byte[] {
    (byte)0xD1, (byte)0x01, (byte)0x0C, (byte)0x55, (byte)0x01, (byte)0x65, (byte)0x78, (byte)0x61, (byte)0x6D, (byte)0x70, (byte)0x6C, (byte)0x65, (byte)0x2E, (byte)0x63, (byte)0x6F, (byte)0x6D, (byte)0x2F
};

// wrap into TLV structure
byte[] tlvEncodedData = null;
if (ndefMessage.length < 255) {
    tlvEncodedData = new byte[ndefMessage.length + 3];
    tlvEncodedData[0] = (byte)0x03;  // NDEF TLV tag
    tlvEncodedData[1] = (byte)(ndefMessage.length & 0x0FF);  // NDEF TLV length (1 byte)
    System.arraycopy(ndefMessage, 0, tlvEncodedData, 2, ndefMessage.length);
    tlvEncodedData[2 + ndefMessage.length] = (byte)0xFE;  // Terminator TLV tag
} else {
    tlvEncodedData = new byte[ndefMessage.length + 5];
    tlvEncodedData[0] = (byte)0x03;  // NDEF TLV tag
    tlvEncodedData[1] = (byte)0xFF;  // NDEF TLV length (3 byte, marker)
    tlvEncodedData[2] = (byte)((ndefMessage.length >>> 8) & 0x0FF);  // NDEF TLV length (3 byte, hi)
    tlvEncodedData[3] = (byte)(ndefMessage.length & 0x0FF);          // NDEF TLV length (3 byte, lo)
    System.arraycopy(ndefMessage, 0, tlvEncodedData, 4, ndefMessage.length);
    tlvEncodedData[4 + ndefMessage.length] = (byte)0xFE;  // Terminator TLV tag
}

// fill up with zeros to block boundary:
tlvEncodedData = Arrays.copyOf(tlvEncodedData, (tlvEncodedData.length / 4 + 1) * 4);
for (int i = 0; i < tlvEncodedData.length; i += 4) {
    byte[] command = new byte[] {
        (byte)0xA2, // WRITE
        (byte)((4 + i / 4) & 0x0FF), // block address
        0, 0, 0, 0
    };
    System.arraycopy(tlvEncodedData, i, command, 2, 4);
    byte[] response = nfc.transceive(command);
}