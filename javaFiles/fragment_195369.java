if (aField.getType().isArray()) {
  Object array = aField.get(obj);
  int length = Array.getLength(array);
  for (int i = 0; i < length; i++) {
    System.out.println(Array.get(array, i));
  }
}