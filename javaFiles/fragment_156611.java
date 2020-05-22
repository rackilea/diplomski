public static void main(String[] args) throws UnsupportedEncodingException {

    // I use Bouncy Castle.
    SHA256Digest SHA = new SHA256Digest();

    byte[] digest = new byte[32];

    byte[] textBytes;

    long nonce = 0L;

    String message = "blahblabahlsdhqwi";

    boolean found;

    do {

        // Calculate digest.
        textBytes = (message + nonce).getBytes("UTF-8");
        SHA.update(textBytes, 0, textBytes.length);
        SHA.doFinal(digest, 0);

        // Check for 4 zeros.
        found = digest[0] == 0 && digest[1] == 0 && digest[2] == 0 && digest[3] == 0;

        // Try next nonce.
        ++nonce;

    } while (!found);

    System.out.println("Found at: SHA256(" + message + (nonce - 1L) +")");

    System.out.println("SHA256 digest = " + Arrays.toString(digest));

} // end main()