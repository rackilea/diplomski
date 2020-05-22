import java.io.*;
public class Exc3 {

    public static void main(String[] args) {
        int row = 1;
        int i = 0;
        int j = 0;
        int max = 5;
        for (i = 1; i <= row; i++) {
            System.out.print(i);
            System.out.print(" ");

            if (i == row) {
                for (j = 1; j <= max; j++) {
                    System.out.print("  ");
                }
                for (j = 1; j <= max; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
                i = 0;
                row++;
                max--;
            }
            if (row > 5)
                break;
        }
    }
}