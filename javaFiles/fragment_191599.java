int[][] array = {{1, 2}, {3, 4}, {5, 6}}; 
List<Integer> list = new ArrayList<>();
for (int[] array1 : array) {
    for (int j = 0; j < array1.length; j++) {
        list.add(array1[j]);
    }
}