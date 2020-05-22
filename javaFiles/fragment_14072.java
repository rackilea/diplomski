public class Boxing {

  private static final Map<Class<?>, Function> MAPPER = createMapper();

  private static Map<Class<?>, Function> createMapper() {
    Map<Class<?>, Function> mapper = new HashMap<>();
    mapper.put(int[].class, toBoxedIntArray());
    mapper.put(long[].class, toBoxedLongArray());
    // TODO put mapping functions for remaining primitive array types
    return mapper;
  }

  @SuppressWarnings("unchecked")
  public static <T> T[] toBoxedArray(Object array) {
    if (array == null || !array.getClass().isArray() || !array.getClass().getComponentType().isPrimitive()) {
      return null;
    }

    return (T[]) MAPPER.get(array.getClass()).apply(array);
  }

  private static Function<int[], Integer[]> toBoxedIntArray() {
    return array -> {
      Integer[] boxed = new Integer[array.length];
      Arrays.setAll(boxed, index -> Integer.valueOf(array[index]));
      return boxed;
    };
  }

  private static Function<long[], Long[]> toBoxedLongArray() {
    return array -> {
      Long[] boxed = new Long[array.length];
      Arrays.setAll(boxed, index -> Long.valueOf(array[index]));
      return boxed;
    };
  }

  // TODO implement mapping functions for remaining primitive array types

  public static <T> List<T> castArrayToList(Object array) {
    T[] boxedArray = toBoxedArray(array);
    return boxedArray != null ?
      Arrays.asList(boxedArray) :
      null;
  }

  public static List castArrayToList(Collection collection) {
    return new ArrayList<>(collection);
  }

}