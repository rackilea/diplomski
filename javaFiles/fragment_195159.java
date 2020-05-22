public class App {

    public static void main(String[] args) {
        new App();
    }
    public App()
    {
        ArrayList<Student> students = new ArrayList<Student>();
        Student A = new Student("John", "Doe", 1000);
        students.add(A);
        Student B = new Student("Michael", "Hawk", 2000);
        students.add(B);
        Student C = new Student("Nicholas", "Johnson", 3000);
        students.add(C);

        for (Student student : students)
        {
            if (student.getIndex() == 1000)
            {
                student.getPassedExamList().add(new PassedExam("CS102", 6));
                student.getPassedExamList().add(new PassedExam("CS220", 8));
            }
            if (student.getIndex() == 2000)
            {
                student.getPassedExamList().add(new PassedExam("MA101", 10));
                student.getPassedExamList().add(new PassedExam("CS101", 7));
            }
            if (student.getIndex() == 3000)
            {
                student.getPassedExamList().add(new PassedExam("CS115", 9));
                student.getPassedExamList().add(new PassedExam("MA102", 7));
            }
        }
        for (Student student : students)
        {
            System.out.println(student.toString() + " " + student.getPassedExamList());
        }
        Collections.sort(students);
        System.out.println("\nSorted\n");
        for (Student student : students)
        {
            System.out.println(student.toString() + " " + student.getPassedExamList());
        }

        System.out.println("\nCalculating average\n");
        double total = 0;
        double count = 0;
        for (Student student : students)
        {
            count += student.getPassedExamList().size();
            total += student.getTotalMarks();
        }
        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println("Average is " + df.format(total / count));
    }
}