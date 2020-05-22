private String toStringHelper(ArrayList<E> elements, int index) {

    if (index >= elements.size())
      return "";
    String s = toStringHelper(elements, index + 1);
    if (index < elements.size() - 1)
      s += ", ";
    s += elements.get(index).toString();
    return s;
  }