private byte[] genTwoKey3DES(byte[] key) {
    byte[] keyAux;
    if (key.length == 16) {
        keyAux = new byte[24];
        System.arraycopy(key, 0, keyAux, 0, 16);
        System.arraycopy(key, 0, keyAux, 16, 8);
    } else {
        keyAux = key;
    }
    return keyAux;
}