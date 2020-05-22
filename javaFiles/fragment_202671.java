public class assignment04 {
    public static void main(String[] args) {
        int size = 5;

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (row == column || column == (size - row - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}