public static int ascending(int min, int max) {
    int total = 0;
    for (int i = min; i < max + 1; i++) {
       System.out.print(i + " ");
       total += i;
     }
     return total;
}