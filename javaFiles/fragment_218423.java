public class Question_55386466{

        static int X = 6;
        static int Y = 7;

        public static void printGrid() {
            System.out.print("  ");         // Printing the space on the top left corner
            for (int i = 0; i < X; i++) {
                if (i > 0) {                // Printing the numbers column on the left, taking i>0 to start from the second line (i == 1)
                    System.out.println();   // Going to the next line after printing the whole line
                    System.out.print(i - 1);//Printing the numbers of the column. Taking i-1 because we start the count for i == 1 not 0
                }
                for (int j = 0; j < Y; j++) {
                    if (i == 0)
                        System.out.print(j + "  ");//Print the first line numbers.
                    else
                        System.out.print(" * "); //if the line isn't the first line(i == 0), print the asterixes.

                }

            }
        }