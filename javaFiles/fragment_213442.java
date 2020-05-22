try {
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    Key key = new SecretKeySpec("c88ba867994f440963f55b727cdd3cb7".getBytes("UTF-8"), "AES");
    IvParameterSpec iv = new IvParameterSpec(new byte[16]);
    cipher.init(Cipher.ENCRYPT_MODE, key, iv);

    byte[] testString = "666326911".getBytes("UTF-8");

    byte[] encrypted = cipher.doFinal(testString);
    System.out.println("Encrypt Hex: " + Hex.encodeHexString(encrypted));
} catch (Exception e) {
    System.err.println("Uh-ohh...");
    e.printStackTrace();
}