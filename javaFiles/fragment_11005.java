if (x >= board.length) { // This tests to make sure the knight does not move off the row
    System.out.println("Cannot move off board on x axis");
    x -= 1;
}
else if (y >= board.length) { // This tests to make sure the knight does not move off the column
    System.out.println("Cannot move off board on y axis");
    y -= 2;
}