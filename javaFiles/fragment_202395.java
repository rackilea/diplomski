public static void main(String[] args) {
    for (int d3 = 10; d3 >= 0; d3--) {
        for (int d2 = 10 - d3; d2 >= 0; d2--) {
            int d1 = 10 - d2 - d3;
            System.out.println(d1/10d + "  " + d2/10d + "  " + d3/10d);
        }
    }
}