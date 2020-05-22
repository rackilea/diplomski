function hash (){
       return CryptoJS.SHA256(password);
    }
    var cipher = (function(plaintext, password) {
                        passwordHash = hash(password);
                        var iv = CryptoJS.enc.Hex.parse('0000000000000000');
                        var cipher = CryptoJS.AES.encrypt(plaintext, passwordHash, {
                            iv: iv,
                            mode: CryptoJS.mode.CBC,
                            keySize: 256 / 32,
                            padding: CryptoJS.pad.Pkcs7
                        });
                        return cipher;
    })(plaintext, password);

   cipherBase64 =  cipher.ciphertext.toString().hex2a().base64Encode();