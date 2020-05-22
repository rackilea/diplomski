int[] a = {1, 2, 3, 4, 5, 6};
int[] logicalarray = {0, 1, 0, 0, 0, 1};
int[] result = IntStream.range(0, logicalarray.length) // create a stream of array indexes
        .filter(i -> logicalarray[i] == 1) // filter the indexes which are 1 in logicalarray
        .map(i -> a[i]) // map the related value from array a
        .toArray(); // create an array of the values
System.out.println("result = " + Arrays.toString(result));