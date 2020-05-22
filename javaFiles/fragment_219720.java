Write = new byte[]{
            (byte) 0x02, // Flags
            (byte) 0x21, // Command: Write 1 blocks
            (byte) 0x5A, // First block (offset)
            (byte) 0x41,
            (byte) 0x00,
            (byte) 0x00,
            (byte) 0x00  
    };
nfcvTag.transceive(Write);