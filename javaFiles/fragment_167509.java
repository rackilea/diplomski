@Test
public void test() {
    String[][] array = new String[100][100];
    for (int i=0;i< 10; i++) {
        for (int j=10; j< 16; j++) {
            array[i][j] = "abcd";
        }
    }

    array = (String[][]) Arrays.asList(array).stream()
                            // Filters out empty arrays
                            .filter(checkEmptyArrays())
                            // Filters out empty strings
                            .map(x -> cleanUpEmptyStrings(x))
                            // Collects it all back into the array matrix
                            .collect(Collectors.toList()).toArray(new String[0][0]);

    for (String[] a: array) {
        System.out.println(a.length);
    }

}