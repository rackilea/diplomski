public static String gensalt(int log_rounds, SecureRandom random, String plaintextSalt) {

    byte[] plaintextByte = plaintextSalt.getBytes();
    byte rnd[] = new byte[BCRYPT_SALT_LEN];

    //Use all of the string if size >= of the reqired rnd size
    if (plaintextByte.length >= BCRYPT_SALT_LEN) {
        System.arraycopy(plaintextByte, 0, rnd, 0, rnd.length);

    } else {
        //copy all of the string byte array
        System.arraycopy(plaintextByte, 0, rnd, 0, plaintextByte.length);

        //fill the rest with random
        byte[] tempArray = new byte[BCRYPT_SALT_LEN - plaintextByte];
        random.nextBytes(tempArray);
        System.arraycopy(tempArray, 0, rnd, plaintextByte.length, temp.length);
    }

    StringBuffer rs = new StringBuffer();

    rs.append("$2a$");
    if (log_rounds < 10)
        rs.append("0");
    if (log_rounds > 30) {
        throw new IllegalArgumentException(
                "log_rounds exceeds maximum (30)");
    }
    rs.append(Integer.toString(log_rounds));
    rs.append("$");
    rs.append(encode_base64(rnd, rnd.length));
    return rs.toString();

}