ArrayList<ArrayList<double[]>> allPacks = new ArrayList<ArrayList<double[]>>();
    for (int i = 0; i < matrix.length - 10; i += 10) {
        System.out.println(i);
        ArrayList<double[]> batch = new ArrayList<double[]>();
        for (int j = 0; j < 10; j++) {
            batch.add(matrix[i + j]);
        }
        allPacks.add(batch);
    }