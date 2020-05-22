public static int mode(int[][] arr) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < arr.length; i++) {
        // tiny change 1: proper dimensions
        for (int j = 0; j < arr[i].length; j++) { 
            // tiny change 2: actually store the values
            list.add(arr[i][j]); 
        }
    }

    // now you need to find a mode in the list.

    // tiny change 3, if you definitely need an array
    int[] vector = new int[list.size()];
    for (int i = 0; i < vector.length; i++) {
        vector[i] = list.get(i);
    }
}