import org.apache.commons.codec.binary.Base64;

// "AES" is the key generation algorith, you might want to use a different one.
KeyGenerator kg = KeyGenerator.getInstance("AES"); 

// 256-bit key, you may want more or fewer bits.
kg.init(256);

SecretKey key = kg.generateKey();
byte[] keyBytes = key.getEncoded();

// Encode to a String, e.g. base 64 encoded
String encodedKey = new String(Base64.encodeBase64(keyBytes), "UTF-8");