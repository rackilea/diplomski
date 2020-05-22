short oldshort = 700;

    byte byte1= (byte) (oldshort);
    byte byte2= (byte) ((oldshort >> 8) & 0xff);

    short newshort = (short) ((byte2 << 8) + (byte1&0xFF);

        System.out.println(oldshort);
    System.out.println(newshort);