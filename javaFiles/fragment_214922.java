public static final int[] DIGITS_POWER
        //  0  1   2     3    4        5        6       7         8
        = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

public String generateHOTP(long count, String seedString) {

    byte[] counter = new byte[8];
    long movingFactor = count;

    for (int i = counter.length - 1; i >= 0; i--) {
        counter[i] = (byte) (movingFactor & 0xff);
        movingFactor >>= 8;
    }

    //from org.apache.commons.codec.binary.Base32;

    Base32 base32 = new Base32();
    byte[] seed = base32.decode(seedString);


    byte[] hash = HMAC(seed, counter);
    int offset = hash[hash.length - 1] & 0xf;

    int otpBinary = ((hash[offset] & 0x7f) << 24)
            | ((hash[offset + 1] & 0xff) << 16)
            | ((hash[offset + 2] & 0xff) << 8)
            | (hash[offset + 3] & 0xff);

    int otp = otpBinary % DIGITS_POWER[6];
    String result = Integer.toString(otp);

    while (result.length() < 6) {
        result = "0" + result;
    }
    return result;

}

 private byte[] HMAC(byte[] seed, byte[] counter) {

    try {
        Mac hmac = Mac.getInstance("HmacSHA1");
        SecretKeySpec macKey = new SecretKeySpec(seed, "RAW");
        hmac.init(macKey);
        return hmac.doFinal(counter);

    } catch (GeneralSecurityException ex) {
        throw new UndeclaredThrowableException(ex);
    }
}