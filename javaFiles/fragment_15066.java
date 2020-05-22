byte[] b = {1, 2, 3, 4, 5}; //Initial byte array also can be gotten from any other source
    String s = b.toString(); //[1, 2, 3, 4, 5]

    String[] sa = s.substring(1, s.length() - 1).split(",");
    byte[] ba = new byte[sa.length];

    for(int i = 0; i < ba.length; i++) {
        ba[i] = Byte.valueOf(sa[i].trim());
    }

    //Now ba should contain 1, 2, 3, 4, 5