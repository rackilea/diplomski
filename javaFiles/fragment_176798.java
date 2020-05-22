public static BigInteger fromString(String bigIntString) {
  if (bigIntString == null || bigIntString.length() == 0) {
    return null;
  }

  return new BigInteger(bigIntString);
}