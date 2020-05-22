public static <T> String common(Set<T> set, Function<? super T, String> extractor) {

    Iterator<T> first = set.iterator();
    String id1 = "";
    while (first.hasNext()) {
         id1 = extractor.apply(first.next());
        if (id1.equalsIgnoreCase("ABC")) {
    return id1 ;
        }
    }
    return id1 ;

}