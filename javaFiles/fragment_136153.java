public static <T> List<T> rearrange(List<T> items, T input) {
  int index = items.indexOf(input);
  List<T> copy;
  if (index >= 0) {
    copy = new ArrayList<T>(items.size());
    copy.add(items.get(index));
    copy.addAll(items.subList(0, index));
    copy.addAll(items.subList(index + 1, items.size()));
  } else {
    return items;
  }
  return copy;
}