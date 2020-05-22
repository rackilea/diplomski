Object[][] grouped = IntStream.range(0, array[0].length) // this will create a stream containing as many natural numbers, starting from 0, that the array has elements
        .boxed() // this will make it a stream of Integers instead of ints
        .collect(groupingBy(i -> array[1][i], mapping(i -> array[0][i].toString(), joining(", ")))) // here, we make a Map out of the stream by grouping by the i'th element of the second column in the matrix and taking as the value the respective element from the first column, then joining the resulting list of strings in the map's value with a ", " separator
        .entrySet() // now we take the entry set of the map
        .stream() // we stream it
        .map(e -> new Object[] {e.getValue(), e.getKey()}) // and we transform each entry in the map into a matrix row
        .toArray(Object[][]::new); // finally, we transform the stream of rows into a matrix (array of rows)