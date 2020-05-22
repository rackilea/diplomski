if (lhs.det() == 0) {
    System.out.println("No solution or infinite number of solutions");
} else {
    Matrix ans = lhs.solve(rhs);
    //Printing Answers
    System.out.println("x1 = " + (ans.get(0, 0)));
    System.out.println("x2 = " + (ans.get(1, 0)));
    System.out.println("X3 = " + (ans.get(2, 0)));
    System.out.println("X4 = " + (ans.get(3, 0)));
}