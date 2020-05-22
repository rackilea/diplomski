public class s {
    public static void main(String[] args) {
        int a = 10;
        System.out.printf("%3s | ", "x");
        for (int b = 1; b <= a; b++) {
            System.out.printf("%3d | ", b);
        }
        System.out.println();
        System.out.printf("----+");
        for (int d = 0; d < a; d++) {
            System.out.printf("-----+");
        }
        System.out.println();
        for (int e = 1; e <= a; e++) {
            System.out.printf("%3d | ", e);
            for (int c = 1; c <= a; c++) {
                System.out.printf("%3d | ", e * c);
            }
            System.out.println();
        }
    }
}