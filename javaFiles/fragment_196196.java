public static String caesarify(String text, int key) {
  String shiftA = shiftAlphabet(key);

  char[] charArrayShifted = shiftA.toCharArray();
  char[] charArrayText = text.toCharArray();
  for(int i = 0; i < charArrayText.length; i++){
      // shift every element of charArrayText for the value of charArrayShifted for the key
      int shifted = (int) charArrayText[i] + (int)charArrayShifted[key-1];
      // if the sum is higher than the value of Z, subtract the value of A
      if (shifted > (int) 'Z'){
          shifted-=(int)'A';
      }
      charArrayText[i] = (char)shifted;
  }
return new String(charArrayText);
}