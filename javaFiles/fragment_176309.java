IntStream.range(0, 100).filter(x -> x % 3 == 0).forEach((x) -> x = x + 2); 

IntStream.range(0, 100 / 3).map(x -> x * 3).forEach((x) -> x = x + 2); 

int limit = ( 100 / 3 ) + 1; 
IntStream.iterate(0, n -> n + 3).limit(limit).forEach((x) -> x = x + 2);