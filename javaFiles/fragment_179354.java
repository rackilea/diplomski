public static void printGradeSheet()
{
    gradeSheet = "********************************* \n\n" + 
       assignmentTitle + "\n\n" +
       studentName + " " + idNumber + "\n\n" +
       "Grade Summary:\n\n" +
       "Program Correctness:        Quality of Style:\n" +
       "Late Deduction:              Overall Score:\n" +
       "Comments:";
    System.out.println(gradeSheet);
}