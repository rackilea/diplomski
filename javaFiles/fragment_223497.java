public static void NumPyramid(int max) {
    for (int i=1; i<=max; ++i) {
        for (int j=1; j<=i; ++j)
            System.out.println(j + " "); 
        System.out.println();
    }
}