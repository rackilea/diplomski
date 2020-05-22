String[] Array_3 = 
    IntStream.range(0,Array_1.length)
             .boxed()
             .flatMap(i -> Stream.of(Array_1[i],Array_2[i]))
             .toArray(String[]::new);
System.out.println (Arrays.toString(Array_3));