public int compare(Item a, Item b) {
  String nameA = a.getName();
  String nameB = b.getName();

  int kindA = kind(nameA);
  int kindB = kind(nameB);
  if (kindA != kindB) {
    return Integer.compare(kindA, kindB);
  } else {
    return nameA.compareToIgnoreCase(nameB);
  }
}