public static long test1(int[][][] array) {
    long start = System.currentTimeMillis();
    for ( int x = 0; x < 400; x++ ) {
        for ( int y = 0; y < 300; y++ ) {
            for ( int z = 0; z < 400; z++ ) {
                array[x][y][z] = x + y + z;
            }
        }
    }
    return System.currentTimeMillis() - start;
}

public static long test2(int [] array) {
    long start = System.currentTimeMillis();
    for ( int x = 0; x < 400; x++ ) {
        for ( int y = 0; y < 300; y++ ) {
            for ( int z = 0; z < 400; z++ ) {
                array[z + y*400 + x*400*300] = x + y + z;
            }
        }
    }
    return System.currentTimeMillis() - start;
}

public static void main(String[] args) {

    int[][][] a1 = new int[400][300][400];
    int[] a2 = new int[400*300*400];
    int n = 20;

    System.err.println("test1");
    for (int i=0; i<n; i++) {
        System.err.print(test1(a1) + "ms ");
    }
    System.err.println();
    System.err.println("test2");
    for (int i=0; i<n; i++) {
        System.err.print(test2(a2) + "ms ");
    }
    System.err.println();
}