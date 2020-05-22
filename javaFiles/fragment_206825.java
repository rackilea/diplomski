Aes.generateKey = function(salt, passPhrase) {
  console.log(this.keySize);
  console.log(this.iterationCount);
  var key = CryptoJS.PBKDF2(
          passPhrase, 
          CryptoJS.enc.Hex.parse(salt),
          { keySize: this.keySize, iterations: this.iterationCount });
  return key;
 }