int[] Array1 = new int[] {3,3,3};
    int[] Array2 = new int[] {3,2,1};
    int[] Array3 = new int[Array2.length];

    for(int i = 0; i<Array1.length; i++) {
        Array3[i] = Integer.parseInt(String.valueOf(Array1[i])+String.valueOf(Array2[i]));
    }