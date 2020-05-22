public boolean isCardDistinctFromAllOtherCards(int indexToCheck) {
  for (int i=0; i<cardString.length-1; i+=2) {
    if (i == indexToCheck) {
      continue;
    }
    if (cardString.charAt(indexToCheck) == cardString.charAt(i)) {
      return false;
    }
  }
  return true;
}