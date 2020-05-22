public class JavaApplication8 {

    public static void main(String[] args) {

        int i = 1;
        int j = 1;

        while (i <= 2 && j <= 4) {

            while (i <= 2 && j <= 4) {

                System.out.printf("%d%d\n", i, j);

                j++;
            }

            j = j - 4;

            i++;

            System.out.printf("%d%d\n", i, j); // <=== This one
            j++;

        }

    }
}