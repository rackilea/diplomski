int bits = Float.floatToIntBits(myFloat);
byte[] bytes = new byte[4];
bytes[0] = (byte)(bits & 0xff);
bytes[1] = (byte)((bits >> 8) & 0xff);
bytes[2] = (byte)((bits >> 16) & 0xff);
bytes[3] = (byte)((bits >> 24) & 0xff);