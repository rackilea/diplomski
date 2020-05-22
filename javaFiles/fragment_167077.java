public static <T> List<T> getListFromIterator(Iterator<T> iterator) { 
    Iterable<T> iterable = () -> iterator; 

    return StreamSupport 
              .stream(iterable.spliterator(), false) 
              .collect(Collectors.toList()); 
}