public static <T> Set<T> getObjects(Class<T> clazz) {
      if (clazz == null) {
          throw new IllegalArgumentException();
      }
      return getAllTheObjects().stream()
                               .filter(clazz::isInstance)
                               .map(clazz::cast)
                               .collect(Collectors.toSet());
 }