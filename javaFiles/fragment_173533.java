public function decrypt($data="", $key = NULL) {
    if($key != NULL && $data != ""){
        $method = "AES-256-CBC";
        $key1 = mb_convert_encoding($key, "UTF-8");//Encoding to UTF-8
        // Base64-decode data
        $dataDecoded = base64_decode($data);
        // Derive salt, IV and encrypted text from decoded data
        $salt1 = substr($dataDecoded,0,20); 
        $IVbytes = substr($dataDecoded,20,16); 
        $dataEncrypted = substr($dataDecoded,36); 
        // SecretKeyFactory Instance of PBKDF2WithHmacSHA1 Java Equivalent
        $hash = openssl_pbkdf2($key1,$salt1,'256','65556', 'sha1'); 
        // Decrypt
        $decrypted = openssl_decrypt($dataEncrypted, $method, $hash, OPENSSL_RAW_DATA, $IVbytes);
        return $decrypted;
    }else{
        return "Encrypted String to decrypt, Key is required.";
    }
}