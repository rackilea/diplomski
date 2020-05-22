import java.util.*;

public class MyClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a number range: ");
        int numOfCols = input.nextInt();

        System.out.print("Please enter a number of rows: ");
        int numOfRows = input.nextInt();

        for (int i = 1; i <=numOfRows; i++) {
            for (int j = 1; j <= numOfCols; j++){
                for (int k = 1; k <= numOfCols; k++){
                    if (k == i) {
                        System.out.print(k+j-1);
                    } else {
                        System.out.print(1);
                    }
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}