public static <T> List<T> MyFunction(Class<T> clazz) {
    if (clazz == null) {
      return null;
    }
    T item;
    List<T> items = new ArrayList<T>();
    for (int i = 0; i < 5; i++) {
      try {
        item = clazz.newInstance();
      } catch (Exception e) {
        item = null;
      }
      if (item != null) {
        items.add(item);
      }
    }
    return items;
  }