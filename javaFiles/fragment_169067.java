public static int[][] sort(int[][] x) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a.add(x[i][j]);

            }
        }

        Collections.sort(a);

        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                x[i][j] = a.get(k);
                k++;
            }
        }

        return x;
    }