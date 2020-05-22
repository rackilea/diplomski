int[][] vals = {{2, 4, 8}, {1, 5, 7}, {3, 9, 6}};

int[] min = IntStream
               .range(0, vals[0].length)
               .map(j -> IntStream.range(0, vals.length).map(i -> vals[i][j]).min().getAsInt())
               .toArray();

System.out.println(Arrays.toString(min));       // Prints [1, 4, 6] as expected