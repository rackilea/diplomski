$rsa = new Crypt_RSA();
$keys = $rsa->createKey(2048);
// [...]

$macKey = base64_decode($base64EncodedMacKey);

$rsa->setEncryptionMode(CRYPT_RSA_ENCRYPTION_PKCS1);
$rsa->loadKey($keys['privatekey']);
$decryptedMac = $rsa->decrypt($macKey);