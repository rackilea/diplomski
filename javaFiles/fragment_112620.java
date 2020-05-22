String string = getString(); // returns the string you will parse
boolean japaneseChars = true;
for (ii=0; ii<string.length; ii++) {
    char character = string.charAt(ii);
    if (!(character >= 0x30A0 && character<= 0x30FF)) {
         japaneseChars = false;
    }
}