int input = ...
    byte[] output = new byte[4];
    output[0] = (byte) ((input >> 24) & 0xff);
    output[1] = (byte) ((input >> 16) & 0xff);
    output[2] = (byte) ((input >> 8) & 0xff);
    output[3] = (byte) (input & 0xff);