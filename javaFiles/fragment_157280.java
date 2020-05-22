public static function encryptAES($data, $AES_key)
    {
        $AES_key = base64_decode($AES_key);
        $encrypt = openssl_encrypt($data, 'aes128', $AES_key);
        if (!$encrypt) {
            throw new Exception('AES encryption error');
        }
        return base64_encode($encrypt);
    }