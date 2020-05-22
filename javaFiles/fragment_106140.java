double[] my_sum = 
    id1.values().stream()
                .map(Link::getFlows)
                .reduce(
                    new double[3],
                    (v1, v2) -> IntStream.range(0, v2.length).mapToDouble(i -> v1[i] + v2[i]).toArray()
                );

System.out.println(Arrays.toString(my_sum)); // prints [100.0, 7.0, 66.0]