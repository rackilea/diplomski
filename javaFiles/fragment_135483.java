import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter number of rows in seating arrangment: ");
        int rowNo = s.nextInt();

        String[][] seating = new String[rowNo][4];
        for (int i = 0; i < rowNo; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 0)
                    seating[i][j] = "A";
                else if (j == 1)
                    seating[i][j] = "B";
                else if (j == 2)
                    seating[i][j] = "C";
                else
                    seating[i][j] = "D";
            }
        }

        // Extracted your printing into a method
        printSeating(seating);

        String askUser = "Y";
        while (askUser.equalsIgnoreCase("Y")) {
            System.out.println("Chose your Seat ");

            System.out.println("Enter the row  ");
            int row = s.nextInt();
            // nextInt() only gets the int and doesn't consume the newline
            // so this consumes the newline
            s.nextLine();

            System.out.println("Enter the column  ");
            String col = s.nextLine();

            if (col.equals("A"))
                seating[row - 1][0] = "X";
            else if (col.equals("B"))
                seating[row - 1][1] = "X";
            else if (col.equals("C"))
                seating[row - 1][2] = "X";
            else
                seating[row - 1][3] = "X";

            System.out.println("Contnioe to choose seat [y -Yes | n-No] :");
            askUser = s.next();
        }

        System.out.println("Find Seating");
        // Extracted your printing into a method
        printSeating(seating);
    }


    private static void printSeating(String[][] seating) {
        for (int i = 0; i < seating.length; i++) {
            // Don't print a newline, since you want to continue printing on this line
            System.out.print(i + 1);
            for (int j = 0; j < seating[i].length; j++) {
                // Don't print a newline, since you want to continue printing on this line
                System.out.print(" " + seating[i][j]);
            }
            // now you print a newline
            System.out.println();
        }
    }
}