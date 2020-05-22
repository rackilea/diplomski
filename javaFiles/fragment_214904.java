String serialzed_key = // ...

byte[] encoded_key = // serialzed_key -> byte array conversion

// If key is private, use PKCS #8

PKCS8EncodedKeySpec formatted_private = new PKCS8EncodedKeySpec(encoded_key);

// or, if key is public, use X.509

X509EncodedKeySpec formatted_public = new X509EncodedKeySpec(encoded_key);

// Retrieve key using KeyFactory

KeyFactory kf = KeyFactory.getInstance("EC");

PublicKey pub = kf.generatePublic(formatted_public);

PrivateKey priv = kf.generatePrivate(formatted_private);