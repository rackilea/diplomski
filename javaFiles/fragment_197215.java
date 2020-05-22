$options = array('private_key_bits' => 1024,
            'private_key_type' => OPENSSL_KEYTYPE_RSA,
            'config' => realpath(__DIR__) . '/openssl.cnf');

        #Get Client Public Key  
        $keyData = openssl_pkey_get_details($pkGenerate);
        $clientPublicKey = $keyData['key'];
        $this->clientData['clientPublicKeyPEM'] = $keyData['key'];