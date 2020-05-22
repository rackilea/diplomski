public static float[][] clone(float[][] a) throws Exception {
    float b[][] = new float[a.length][a[0].length];

    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[0].length; j++) {
            b[i][j] = a[i][j];
        }
    }
    return b;
}



    float[][] a = new float[][] { { 1.513f, 2.321f, 3.421f }, { 4.213f, 5.432f, 6.123f },
            { 7.214f, 8.213f, 9.213f } };

    try {
        float b[][] = clone(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    } catch (Exception e) {
        System.out.println("Error!!!");
    }