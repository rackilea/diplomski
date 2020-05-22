public static <E extends Enum<E>> List<E> getEnumList(String csvLine, Class<E> clazz) {
    List<String> csvList = Arrays.asList(csvLine.split(","));

    Function<String, E> enumList = new Function<String, E>() {
       @Override
       public E apply(String csvStr) {
          return Enum.valueOf(clazz, "");
       }
    };

    return Lists.transform(csvList, enumList);
}