// Public methods
  public int getNoOfItems() {
    return noOfItems;

  }

  public String getItemAt(int index) {
    if (index >= noOfItems) {
      return null;
    } else {
      return theItems[index];
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder("[");
    for (int i = 0; i < theItems.length; i++) {
      if (theItems[i] != null) {
        builder.append(theItems[i]).append(";");
      }
      builder.append("]");
      return builder.toString();
    }