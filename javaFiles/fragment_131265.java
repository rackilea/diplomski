public static byte[] getRandomIv() throws InvalidDataException {
    try {
        SecureRandom sr = new SecureRandom();
        byte[] output = new byte[16];
        sr.nextBytes(output);
        return output;
    } catch(Exception ex) {
        Log.e(TAG, "Unable to create random IV", ex);
        throw new InvalidDataException("Unable to create random IV");
    }
}