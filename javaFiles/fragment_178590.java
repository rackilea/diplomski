public String[] decrypt(String input) {

    String[] oocc1And2 = new String[2];
    OOCaesarCipher oocc1 = new OOCaesarCipher(26-mainKey1);
    OOCaesarCipher oocc2 = new OOCaesarCipher(26-mainKey2);

    oocc1And2[0] = oocc1.encrypt(input);
    oocc1And2[1] = oocc2.encrypt(input);
    return oocc1And2;

 }