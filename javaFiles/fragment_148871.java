QString encrypt(QByteArray r, const QString &password)
 {
const char *sample = r.data();
string plain = password.toStdString();
string ciphertext;
// Generate Cipher, Key, and CBC
byte key[ AES::MAX_KEYLENGTH ], iv[ AES::BLOCKSIZE ];
//StringSource( reinterpret_cast<const char *>(sample), true,
//              new HashFilter(*(new SHA256), new ArraySink(key, AES::MAX_KEYLENGTH)) );
for(int i=0; i< AES::MAX_KEYLENGTH; ++i){
    key[i] = reinterpret_cast<const char *>(decodedKey)[i];
}
memset( iv, 0x00, AES::BLOCKSIZE );
CBC_Mode<AES>::Encryption Encryptor( key, sizeof(key), iv );
StringSource( plain, true, new StreamTransformationFilter( Encryptor,
              new HexEncoder(new StringSink( ciphertext ) ) ) );
return QString::fromStdString(ciphertext);
}