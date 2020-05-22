public static void main(String[] args) {

    CRC32 crc32 = new CRC32();

    String data = "43HLV109520DAP10072la19z6";

    String[] cs = new String[] {"utf8" /*, "cp1252", "cp866" */};
    byte[] array;
    byte b;

    for(int i=0; i<cs.length; ++i) {

        array = data.getBytes(Charset.forName(cs[i]));

        crc32.reset();
        crc32.update(array);

        System.out.println(String.format("%s: %d", cs[i], crc32.getValue()));

        /*
        for(int j=0; j<array.length/2; j++) {
            b = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = b;
        }
        */

        for(int j=0; j<array.length; j+=2) {
            b = array[i];
            array[i] = array[i+2];
            array[i+1] = b;
        }

        crc32.reset();
        crc32.update(array);

        System.out.println(String.format("of modified: %d", crc32.getValue()));
    }




}