System.out.print("   "); // spacing for the column
for (int j = 1; j <= columns; j++) {
    System.out.printf("%5d", j); // don't need a i * j when i is 1.
}
System.out.println();
System.out.print("   "); // spacing for the column
for (int j = 1; j <= columns; j++) {
    System.out.print("    -"); // print text instead of numbers
    //                12345
}

for (int i = 1; i <= rows; i++) {
    System.out.println("");
    System.out.printf("%d |", i);

    for (int j = 1; j <= columns; j++) {
        System.out.printf("%5d", i * j);
    }
}