/**
 * An aes key derived from a base64 encoded key. This does not generate the
 * key. It's not random or a PBE key.
 *
 * @param keysStr a base64 encoded AES key / hmac key as base64(aesKey) : base64(hmacKey).
 * @return an AES and HMAC key set suitable for other functions.
 */
public static SecretKeys keys(String keysStr) throws InvalidKeyException {...}