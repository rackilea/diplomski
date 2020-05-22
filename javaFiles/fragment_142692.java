String[] inputs = {"a b c d,", "f b h j,", "l p o i,"};
Map<String, List<String>> results =  
     Arrays.stream(inputs).map(s -> s.split(" ")).//splt with space
     collect(Collectors.groupingBy(arr -> arr[1], // Make second element as the key
         Collectors.mapping(arr -> arr[2], // Make third element as the value
                            Collectors.toList())));//collect the values to List
 System.out.println(results);