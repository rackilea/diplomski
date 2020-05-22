execute(channel, new byte[] {
    (byte)0xFF, 0x00, 0x00, 0x00,  // direct PN532 command
    4,                 // Lc = command length
    (byte)0xD4, 0x42,  // InCommunicateThru
    (byte)0xE0, 0x80,  // RATS (FSD = 256, CID = 0)
}, card);