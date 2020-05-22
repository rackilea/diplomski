import static java.util.stream.Collectors.joining;

String s = attributes.entrySet()
                     .stream()
                     .map(e -> e.getKey()+"="+e.getValue())
                     .collect(joining("&"));