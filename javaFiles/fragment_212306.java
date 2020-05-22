public static void main(String[] args) {
        int u, arr[][] = {{1, 7, 2}, {9, 12}, {54, 25, 10}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = j + 1; k < arr[i].length; k++) {
                    if (arr[i][j] > arr[i][k]) {
                        u = arr[i][k];
                        arr[i][k] = arr[i][j];
                        arr[i][j] = u;
                    }
                }
                System.out.print(arr[i][j] + ",");
            }
            System.out.println(" ");
        }
 }