Spliterator<Integer> sp = list.stream()
    //many other filters, flatmaps, etc...
    .filter(i -> condition(i))
    .spliterator();
Stream.Builder<Integer> first = Stream.builder();
boolean flag = sp.tryAdvance(first);
List<Integer> newList = Stream.concat(first.build(), StreamSupport.stream(sp, false))
    //many other filters, flatmaps, etc...
    .collect(Collectors.toList());