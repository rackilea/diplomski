int[][] bar = new int[2][2];
    System.out.println(bar.getClass()); // Outputs class [[I
    int[] bar1 = bar[0];
    System.out.println(bar1.getClass());  // Outputs class [I
    int[] bar2 = bar[1];
    System.out.println(bar2.getClass());  // Outputs class [I