int nDigits=0, i = 0;
CharacterIterator it = new StringCharacterIterator("very long string123456");
for (char ch=it.first(); ch != CharacterIterator.DONE; ch=it.next()) {
  i++;
  nDigits = (ch.isDigit() ? nDigits++ : 0);
  if (nDigits == 5) {
      // DONE. Position is "i"
  }
}