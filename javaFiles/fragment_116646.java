Object[][] array = new Object[10][3];
// fill the array

Object[][] sortedArray = Arrays.stream(array)
        .filter(v -> v[2] != null) //not required if you have the array completely filled
        .sorted(Comparator.comparingDouble(v -> (double) v[2]))
        .toArray(Object[][]::new);

System.out.println(Arrays.deepToString(sortedArray));