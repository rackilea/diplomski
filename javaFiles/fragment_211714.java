char[] chars = str.toCharArray();
int i = 0;
int wordIndex = 0;
while ((wordIndex = str.indexOf(word, i)) != -1) {
    Arrays.fill(chars, i, wordIndex, '+');
    i = wordIndex + word.length();
}
Arrays.fill(chars, i, str.length(), '+');
return new String(chars);