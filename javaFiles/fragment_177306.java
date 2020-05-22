Function<Stream<T1>, Stream<T2>> fnPart1 = 
        s -> s.map(fn1)
            .map(fn2) 
            .filter(fn3);
Function<Stream<T2>, Stream<T3>> fnPart2 = 
        s -> s.flatMap(fn4)
            .map(fn5)      
            .filter(fn6)   
            .map(fn7);

fnPart1.andThen(fnPart2).apply(list.stream()).collect(Collectors.toList());