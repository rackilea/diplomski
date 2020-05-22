public static void main(String[] args) {
        int[][] multi = new int[][]{
                {1, 2},
                {3, 4, 5},
                {6, 7, 8, 9}
        };

        int sum = 0;
        for (int i = 0; i < multi.length; i++) {
            for (int j = 0; j < multi[i].length; j++) {
                sum += multi[i][j];
            }
        }

        System.out.println(sum);
    }