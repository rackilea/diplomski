/**
 * The provider implementation.
 */
private SecureRandomSpi secureRandomSpi = null;

public void nextBytes(byte[] bytes) {
    secureRandomSpi.engineNextBytes(bytes);
}