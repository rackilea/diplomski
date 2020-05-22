int pos = Collections.binarySearch(dividers, word);
if (pos >= 0) {
  // the word is the divider between sets `pos` and `pos+1`
} else {
  int num = -(pos + 1);
  // the word belong to set number `num`
}