char[] splitNumber = encryptedNumber.toCharArray();

for (int i=0; i < encryptedNumber.length(); i++) {
    char c = encryptedNumber.charAt(i);
    for (int j=0; j < conversionTable.length; j++) {
        if (c == conversionTable[j][0].charAt(0)) {
            // do whatever you want here
        }
    }
}