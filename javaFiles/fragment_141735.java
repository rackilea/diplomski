Matrix m = new Matrix(2,2); // Make a 2x2 matrix
m.setElement(0, 0, 11.0);   // row #0, col #0 <- 11.0
m.setElement(0, 1, 12.0);   // row #0, col #1 <- 12.0
m.setElement(1, 0, 21.0);   // row #1, col #0 <- 21.0
m.setElement(1, 1, 22.0);   // row #1, col #1 <- 22.0

// This will print "Yes"
if (m.getElement(0, 0) == 11.0)
    System.out.println("Yes");
else 
    System.out.println("No");