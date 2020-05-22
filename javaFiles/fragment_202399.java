public void something(Object obj) {
  if (obj instanceof List) {
    for (Object element : (List<?>) obj) {
      Item item = (Item) element;  // Potential ClassCastException.
      doStuff();
    }
  } else if (obj instanceof Item[]) {
    for (Item item : (Item[]) obj) {
      doStuff();
    }
  } else {
    throw new IllegalArgumentException();
  }
}