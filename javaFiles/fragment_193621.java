public void add(int index, String element) {
    int len = names.length;
    if (index < len)
      names[index] = element;
    else {
      names = Arrays.copyOf(names, len + (index - len + 1));
      names[index] = element;
    }
  }