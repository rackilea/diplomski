import static java.util.stream.Collectors.joining;

...

i -> list.subList(i, min(i + pageSize, list.size()))
         .stream()
         .map(Object::toString)
         .collect(joining(","))