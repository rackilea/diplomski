int[][] marks = getMarksFromScanner(); //the question is not about this part; might as well omit it.
int total = 0;
for (int i = 0; i < marks.length; i++) {
    int studentTotal = 0;
    for (int mark : marks[i]) 
        studentTotal += mark;
    System.out.println("student " + i + " has a total of " + studentTotal + " points");
    total += studentTotal;
}
System.out.println("The whole class scored " + total + " points");