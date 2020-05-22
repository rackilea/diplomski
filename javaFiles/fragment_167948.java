public void example() throws NoSuchAlgorithmException {
    {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(12345678L);
        System.out.println(secureRandom.nextLong());

    }
    {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(12345678L);
        System.out.println(secureRandom.nextLong());

    }

}