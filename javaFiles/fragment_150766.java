System.out.print("#Please enter the student number : ");
int studentNumber = BIO.getInt();

while(studentNumber > 0) {
    System.out.print("#Please enter the coursework mark : ");
    int courseWork = BIO.getInt();

    System.out.print("#Please enter the exam mark : ");
    int examMark = BIO.getInt();

    double average = (double)(courseWork + examMark) / 2;
    System.out.printf("sn = " + studentNumber
            + " ex = " + examMark + " cw = " + courseWork 
            + " mark = " + average);

    System.out.print("#Please enter the student number : ");
    studentNumber = BIO.getInt();
} 

System.out.print("#End of data");