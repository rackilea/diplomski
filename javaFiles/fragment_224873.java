public class NoMultiples7and9 {

    public static void main(String[] args) {

        for (int i = 1; i <= 30; i++) {

            if (i % 7 != 0 && i % 9 != 0) {

                System.out.println(i);

            }
        }
    }
}