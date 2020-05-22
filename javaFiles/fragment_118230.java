execute(channel, new byte[] {
    (byte)0xFF, 0x00, 0x00, 0x00,  // direct PN532 command
    16,                // Lc = command length
    (byte)0xD4, 0x42,  // InCommunicateThru
    0x02,              // PCB (I-block, change to 0x03 for the next block)
    0x00, (byte)0xA4, 0x04, 0x00,                     // APDU: SELECT (by AID)
      7,                                              // Lc = AID length
      (byte)0xF0, 0x01, 0x02, 0x03, 0x04, 0x05, 0x07, // AID = F0010203040507
      0x00,                                           // Le = max
}, card);