byte[] headerMsg =new byte []  {
    0x0A, 0x01, 0x00, 0x16,
    0x11, 0x0d, 0x0e,
    0x00, 0x00 // to be filled with length bytes
};

int hlen = headerMsg.length;

// I assume the bodyMsg byte array is defined elsewhere
int lenMsg = hlen + bodyMsg.length;


// lobyte of length - mask just one byte with 0xFF
headerMsg[hlen - 1] = (byte) (lenMsg & 0xFF);

// hibyte of length - shift to the right by one byte and then mask
headerMsg[hlen - 2] = (byte) ((lenMsg >> 8) & 0xFF);