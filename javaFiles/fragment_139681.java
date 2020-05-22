String[] A;
String[] B;
List<String> myList;

myList = IntStream.range(0, B.length)
                  .mapToObj(i -> new String[]
                      {
                          A[i],
                          "*".equals(B[i]) ? B[i] : doSomethingWith(B[i])
                      })
                  .flatMap(Arrays::stream)
                  .collect(Collectors.toList());