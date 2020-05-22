public static String M(Set<? extends HasName> set) {

    Iterator<? extends HasName> first = set.iterator();
    String id1 = "";
    while (first.hasNext()) {
         id1 = first.next().getName();
        if (id1.equalsIgnoreCase("ABC")) {
    return id1 ;
        }
    }
    return id1 ;

}