char[] letterBank;
// Read in the chars and separate them into a char array

List<String> myList = new ArrayList<>();

void populateMyList(int depth, String stringSoFar) {
  if (depth == 0) {
    myList.add(stringSoFar)
    return;
  }
  for (int i = 0; i < letterBank.length; i++) {
    populateMyList(depth - 1, stringSoFar + letterBank[i]);
  }
}

main() {
  for(int i = min; i <= max; i++)
    populateMyList(i, "");
}