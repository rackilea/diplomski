// Use the same ECDH Setup that is specified in the generateKeyPair method above
OID CURVE = secp256r1();
DL_GroupParameters_EC<ECP> params(CURVE);
ECDH<ECP>::Domain dhAgreement(params);
dhAgreement.AccessGroupParameters().SetPointCompression(true);

// Figure out how big the public and private keys are
// Public Key: This belongs to the other user
// Private Key: This is out personal private key
int pubLen = (int)(*env).GetArrayLength(publicKeyArray);
int privLen = (int)(*env).GetArrayLength(privateKeyArray);

// Convert the keys from a jbyteArray to a SecByteBlock so that they can be passed
// into the CryptoPP Library functions.
unsigned char* pubData = new unsigned char[pubLen];
(*env).GetByteArrayRegion(publicKeyArray, 0, pubLen, reinterpret_cast<jbyte*>(pubData));

unsigned char* privData = new unsigned char[privLen];
(*env).GetByteArrayRegion(privateKeyArray, 0, privLen, reinterpret_cast<jbyte*>(privData));

SecByteBlock pubB(pubData, pubLen) , privA(privData, privLen);

// Now extract shared secret between the two keys
SecByteBlock sharedSecretByteBlock(dhAgreement.AgreedValueLength());
ALOG("Shared Agreed Value Length: %d", dhAgreement.AgreedValueLength());

bool didWork = dhAgreement.Agree(sharedSecretByteBlock, privA, pubB);

ALOG("Key Agreement: %s", didWork ? "It Worked" : "It Failed");
ALOG("Shared Secret Byte Size: %d", sharedSecretByteBlock.SizeInBytes());

// Return the shared secret as a Java ByteBuffer
jobject sharedSecretByteBuffer = (*env).NewDirectByteBuffer(sharedSecretByteBlock.BytePtr(), sharedSecretByteBlock.SizeInBytes());

// Return the ECDH Key Pair back as a Java ECDHKeyPair object
jclass keyPairClass = (*env).FindClass("com/tcolligan/ecdhtest/SharedSecret");
jmethodID midConstructor = (*env).GetMethodID(keyPairClass, "<init>", "(Ljava/nio/ByteBuffer;)V");
jobject sharedSecretObject = (*env).NewObject(keyPairClass, midConstructor, sharedSecretByteBuffer);

return sharedSecretObject;