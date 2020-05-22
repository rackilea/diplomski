let crypto = require('crypto');

    var iv = new Buffer.from('');   //(null) iv 
    var algorithm = 'aes-256-ecb';
    var password = 'a4e1112f45e84f785358bb86ba750f48';      //key password for cryptography

    function encrypt(buffer){
        var cipher = crypto.createCipheriv(algorithm,new Buffer(password),iv)
        var crypted = Buffer.concat([cipher.update(buffer),cipher.final()]);
        return crypted;
    }

    console.log(encrypt(new Buffer('TextToEncrypt')).toString())