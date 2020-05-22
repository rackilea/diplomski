private String getField(List<String> list, int n) {
  try {
    return list.get(n);
  } catch (NoSuchElementException e) {
    return "";
  }
}

String a = getField(list, 0);
String b = getField(list, 1);