public static void main(String[] args) {
    System.out.println(toTableString(new int[][] { { 1, 2, 3, 4, 5, 6 },
            { 2, 3, 4, 5, 6, 1 }, { 3, 4, 5, 6, 1, 2 },
            { 4, 5, 6, 1, 2, 3 }, { 5, 6, 1, 2, 3, 4 },
            { 6, 1, 2, 3, 4, 5 } }));
    System.out.println();
    System.out.println(toTableString(new int[][] { { 1 }, { 2, 3 },
            { 3, 4, 5 }, { 4, 5, 6, 1 }, { 5, 6, 1, 2, 3 },
            { 6, 1, 2, 3, 4, 5 } }));
    System.out.println();
    System.out.println(toTableString(new int[][] { { 1 }, { 20, 300 },
            { 3000, 40000, 50000 }}));
}