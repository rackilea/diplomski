byte[] buffer = new byte[6];
    buffer[0] = (byte)(v >>> 40);
    buffer[1] = (byte)(v >>> 32);
    buffer[2] = (byte)(v >>> 24);
    buffer[3] = (byte)(v >>> 16);
    buffer[4] = (byte)(v >>>  8);
    buffer[5] = (byte)(v >>>  0);