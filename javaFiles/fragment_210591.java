final Comparator<ItemObject> ignoreLeadingThe = new Comparator<ItemObject>() {

  final Pattern pattern = Pattern.compile("(?i(^the\\s+");

  public int compare(final ItemObject a, final ItemObject b) {
    return pattern.matcher(a.name).replaceAll("")
        .compareToIgnoreCase(pattern.matcher(b.name).replaceAll(""));
  }
};