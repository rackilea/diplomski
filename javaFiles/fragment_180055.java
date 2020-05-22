String s = "This is my message";
try {
    byte[] enc = s.getBytes("UTF-8");
    BigInteger val = new BigInteger(enc);
    System.out.println(val);
    System.out.println(new String(val.toByteArray(), "UTF-8"));
} catch (UnsupportedEncodingException e) {
    e.printStackTrace();
}