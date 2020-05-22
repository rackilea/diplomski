Iterable<int[]> vals = Arrays.asList(new int[][] {{2, 4, 8}, {1, 5, 7}, {3, 9, 6}});

int[] min = IntStream
               .range(0, vals.iterator().next().length)
               .map(j -> StreamSupport.stream(vals.spliterator(), false).mapToInt(a -> a[j]).min().getAsInt())
               .toArray();

System.out.println(Arrays.toString(min));       // Prints [1, 4, 6] as expected