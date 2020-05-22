public static int generateRegistrationId(boolean extendedRange) {
    try {
      SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
      if (extendedRange) return secureRandom.nextInt(Integer.MAX_VALUE - 1) + 1;
      else               return secureRandom.nextInt(16380) + 1;
    } catch (NoSuchAlgorithmException e) {
      throw new AssertionError(e);
    }
  }