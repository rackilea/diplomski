execute(channel, new byte[] {
    (byte)0xFF, 0x00, 0x00, 0x00,  // direct PN532 command
    3,                 // Lc = command length
    (byte)0xD4, 0x12,  // InDataExchange
    (1<<4),            // fAutomaticRATS = 1
}, card);