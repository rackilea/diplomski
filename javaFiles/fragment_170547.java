FileInputStream in = new FileInputStream( "/path/to/pkcs8_private_key.der" );

PKCS8Key pkcs8 = new PKCS8Key( in, "changeit".toCharArray() );

byte[] decrypted = pkcs8.getDecryptedBytes();
PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec( decrypted );

// A Java PrivateKey object is born.
PrivateKey pk = null;
if ( pkcs8.isDSA() )
{
   pk = KeyFactory.getInstance( "DSA" ).generatePrivate( spec );
}
else if ( pkcs8.isRSA() )
{
   pk = KeyFactory.getInstance( "RSA" ).generatePrivate( spec );
}
// For lazier types (like me):
pk = pkcs8.getPrivateKey();