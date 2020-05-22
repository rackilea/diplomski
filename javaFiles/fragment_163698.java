List<String> result = Stream.of("java", "streams", "are", "great", "stuff")
    .filter(s -> {
                  System.out.println("filtering " + s);
                  return s.length()>=4;
                 })
    .map(s -> {
               System.out.println("mapping " + s);
               return s.toUpperCase();
              })
    .limit(3)
    .collect(Collectors.toList());
System.out.println("Result:");
result.forEach(System.out::println);