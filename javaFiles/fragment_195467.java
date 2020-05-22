public static Grades buildGrades(){
    Scanner s = new Scanner(System.in);
    System.out.println("Enter size:");
    int size = s.nextInt();
    Grades grades = new Grades(size);
    grades.enterGradeNames();

    return grades;
}