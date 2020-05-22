public List<String> findArrayMatches(Object [] input, String pattern) {
  List<String> matchingIndices = new ArrayList<>();
  for (int i = 0; i < input.length; i++) {
    Object elem = input[i];
    if (elem instanceof String) {
      String elemString = (String)elem;
      // check if elemString matches pattern and add index to matchingIndices if it does
    } else if (elem instanceof Object[]) {
      Object [] elemArray = (Object[])elem;
      //recursive call here
      List<String> matchingSublevel = findArrayMatches(elemArray, pattern);
      //prepend current index to all items of matchingSublevel and add to matchingIndices
    } else {
      throw new IllegalArgumentException("input is not an array of strings or arrays");
    }
  }
  return matchingIndices;
}