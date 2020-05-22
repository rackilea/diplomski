int center = 7; // From our example.

for (int row = 0; row < 3; ++ row) {
    for (int column = 0; column < 11; ++ column) {
        if (column >= center - row && column <= center + row)
            System.out.print("x"); // Replace with whatever character to print.
        else
            System.out.print(" ");
    }
    System.out.println(); // Line break after each row, of course.
}