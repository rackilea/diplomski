/**
 * Signs it using the encryption algorithm in combination with
 * the digest algorithm.
 * @param message   the message you want to be hashed and signed
 * @return  a signed message digest
 * @throws GeneralSecurityException
 */
public byte[] sign(byte[] message) throws GeneralSecurityException;