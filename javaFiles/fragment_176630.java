package main;

public class Main {

    public static void main(String[] args) {
        shape(9);
        shapeReverse(9);
        shape(12);
        shapeReverse(12);
    }

    public static void shape(int v) {

        // check if v is less than or equal to 1
        if (v <= 1) {
            System.out.println("Error");
            return;
        }

        // check if v is even or odd
        // if even then decrement by 1
        // if odd then do nothing
        v = v % 2 == 0 ? v - 1 : v;

        // declare and initialize a counter for spaces
        int space = 0;

        // loop until v is less than or equal to 0
        while (v > 0) {

            // print out the spaces
            for (int i = 0; i < space; i++) {
                System.out.print(" ");
            }

            // print out the *
            for (int i = 0; i < v; i++) {
                System.out.print("*");
            }

            // decrement v by 2 since each level of the triangle has a difference of 2
            // asterisk
            v = v - 2;

            // increment space by 1 since each level of the triangle starts at different
            // positions
            space++;

            // print a new line
            System.out.println();
        }
    }

    public static void shapeReverse(int v) {

        // check if v is less than or equal to 1
        if (v <= 1) {
            System.out.println("Error");
            return;
        }

        int tmp = 1;

        // declare and initialize a counter for spaces
        int space = v % 2 == 0 ? (v / 2) - 1 : (v / 2);

        // loop until tmp is less than or equal to v
        while (tmp <= v) {

            // print out the spaces
            for (int i = 0; i < space; i++) {
                System.out.print(" ");
            }

            // print out the *
            for (int i = 0; i < tmp; i++) {
                System.out.print("*");
            }

            // increment t by 2 since each level of the triangle has a difference of 2
            // asterisk
            tmp = tmp + 2;

            // decrement space by 1 since each level of the triangle starts at different
            // positions
            space--;

            // print a new line
            System.out.println();
        }
    }

}