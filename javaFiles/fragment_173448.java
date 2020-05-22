Collections.sort(strings, new Comparator<String>() {
  public int compare(String o1, String o2) {
    return Comparator.comparingInt(this::extractInt)
        .thenComparing(Comparator.naturalOrder())
        .compare(o1, o2);
  }

  private int extractInt(String s) {
    try {
      return Integer.parseInt(s.split(":")[1].trim());
    }
    catch (NumberFormatException exception) {
      // if the given String has no number in the second part,
      // I treat such Strings equally, and compare them naturally later
      return -1;
    }
  }
});