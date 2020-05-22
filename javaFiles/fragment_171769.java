import java.util.Scanner;

public class loops {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("enter base:");
        int base = s.nextInt();

        System.out.println("enter height:");
        int h = s.nextInt();

        int spacesNum;
        int asterisksNum;

        for (int i = 1; i <= h; i++) {

            spacesNum = (int) ((Math.pow(base, h) - Math.pow(base, i)) / 2);
            asterisksNum = (int) (Math.pow(base, i));

            for (int j = 0; j < spacesNum; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < asterisksNum; j++) {
                System.out.print("*");
            }

            System.out.println();

        }

        s.close();
    }
}