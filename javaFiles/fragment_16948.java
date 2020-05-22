int[][] marks = getMarksFromScanner(); //the question is not about this part; might as well omit it.
int total = 0;
for (int[] studentMarks : marks)
    for (int mark : studentMarks)
        total += mark;
System.out.println(total);