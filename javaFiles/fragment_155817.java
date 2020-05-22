public class TestMyClass {
    public static void main(String[] args) {
        printMultiplicationTable(4);
    }

    public static void printMultiplicationTable(int size) {
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                if (i==0 && j==0)
                    System.out.print("");
                else if (j == 0)
                    System.out.print(i);
                else if (i == 0)
                    System.out.print("\t" + j);
                else
                    System.out.print("\t" + i * j);
            }
            System.out.println();
        }
    }
}