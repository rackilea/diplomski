List<String> list =  Files.readAllLines(Paths.get("file"));

//readAllLines current implementation returns a RandomAccessList so 
//using get will not have a big performance impact.
//The pipeline can be safely run in parallel
List<Integer> lineNumbers = 
     IntStream.range(0, list.size())
              .filter(i -> list.get(i).contains(word))
              .mapToObj(i -> i + 1)
              .collect(toList());