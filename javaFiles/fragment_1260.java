public static void bytesToFile(String str, File file) throws IOException {
    BufferedOutputStream bos = null;
    try {

        // check for invalid string    
        if(str.length() % 2 != 0) {
            throw new IllegalArgumentException("Hexa string length is not even.");
        }

        if(!str.matches("[0-9a-fA-F]+")) {
            throw new IllegalArgumentException("Hexa string contains invalid characters.");
        }

        // prepare output stream
        bos = new BufferedOutputStream(new FileOutputStream(file));

        // go through the string and make a byte array
        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            String twoChars = str.substring(2 * i, 2 * i + 2);

            int asInt = Integer.parseInt(twoChars, 16);

            bytes[i] = (byte) (asInt & 0xFF);
        }

        // write bytes
        bos.write(bytes);

    } finally {
        if (bos != null) bos.close();
    }
}