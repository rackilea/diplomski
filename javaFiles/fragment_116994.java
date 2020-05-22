public class LetterE {

    public static void main(String args[]) {

        final int NUM_ACROSS = 3; 
        final int NUM_DOWN = 5;        

        for (int row = 1; row <= NUM_DOWN; row++) {
            if (row == 1 || row == NUM_DOWN / 2 + 1 || row == NUM_DOWN)
                for (int column = 2; column <= NUM_ACROSS; column++)
                    System.out.print("*");
            System.out.println("*");
        }
    }
}