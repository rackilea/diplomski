for(int i = 0; i < input.length; i++) {
        output[i*4] = (byte)(input[i] & 0xFF);
        output[i*4 + 1] = (byte)((input[i] & 0xFF00) >>> 8);
        output[i*4 + 2] = (byte)((input[i] & 0xFF0000) >>> 16);
        output[i*4 + 3] = (byte)((input[i] & 0xFF000000) >>> 24);
    }