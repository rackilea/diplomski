public static void main(String[] args) {
    for (int d1 = 0; d1 <= 10; d1++) {
        for (int d2 = 0; d2 <= 10; d2++) {
            for (int d3 = 0; d3 <= 10; d3++) {
                if (d1 + d2 + d3 == 10) {
                    System.out.println("" + d1/10d + "  " + d2/10d + "  " + d3/10d);
                }
            }
        }
    }
}