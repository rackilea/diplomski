ArrayList<String> encryptedBinaryList = new ArrayList<>();
String temp = "";
for (int i = 0; i < ciphertextVals.length; i++) {
    if (i % 2 == 0) {
        temp = Integer.toBinaryString(ciphertextVals[i]);
    } else {
    temp += Integer.toBinaryString(ciphertextVals[i]);
        encryptedBinaryList.add(temp);
    }
}
if (ciphertextVals.length % 2 != 0) {
    encryptedBinaryList.add(temp);
}
String encryptedBinary[] = new String[encryptedBinaryList.size()];
encryptedBinaryList.toArray(encryptedBinary);