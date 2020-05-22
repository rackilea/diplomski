public class NestedLoop {
    public static void main(String[] args) {
        int userNum = 3;
        int i = 0;
        int j = 0;

        while (j <= userNum) {
            System.out.println(j);
            for (i = 0 ; i <= j; ++i) {
                System.out.print(" ");
            }
            ++j;
        }
    }
}