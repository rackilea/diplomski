static <T> Iterable<T> bounded(Iterable<T> iterable, int startIndex, int lastIndex) {
      return StreamSupport.stream(iterable.spliterator(), false)
                          .skip(startIndex+1)
                          .limit(lastIndex-startIndex)
                          .collect(Collectors.toList());
}