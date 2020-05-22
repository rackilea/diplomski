static byte[] doHMAC(byte[] data, byte[] secret)
{
    SecretKey key = new SecretKeySpec(secret, "HmacSHA1");
    Mac m = Mac.getInstance("HmacSHA1");
    m.init(key);
    return m.doFinal(data);
}