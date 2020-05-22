HashSet<int[][]> x = new HashSet<>();
    int a[][] = {{1, 2}, {3, 4}};
    x.add(a);
    int[][] b = {{1, 2}, {3, 4}};
    System.out.println(x.contains(a));
    System.out.println(x.contains(b));