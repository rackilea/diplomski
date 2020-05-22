Class SorterDemo
{      
    static void sortString(Student[] stud)
    {
        Arrays.sort(stud,Student.namecomparator);
    }
    static void sortStudent(Student[] stud)
    {
        Arrays.sort(stud,Student.markscomparator);
    }
    public static void main(String[] args)
    {
        Student student[] = new Student[3];



        // initializing unsorted double array
        double dArr[] = { 3.2, 1.2, 9.7, 6.2, 4.5 };
        // let us print all the elements available in list
        for (double number : dArr) {
            System.out.println("Number = " + number);
        }

        // sorting array
        Arrays.sort(dArr);

        // let us print all the elements available in list
        System.out.println("The sorted double array is:");
        for (double number : dArr) {
            System.out.println("Number = " + number);
        }

        student[0] = new Student();
        student[0].setName("Nick");
        student[0].setmarks(19);

        student[1] = new Student();
        student[1].setName("Helen");
        student[1].setmarks(12);

        student[2] = new Student();
        student[2].setName("Ross");
        student[2].setmarks(16);

        System.out.println("Order of students before sorting is: ");

        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i].getName() + "\t" + student[i].getmarks());
        }

        sortStudent(student);
        System.out.println("Order of students after sorting by student marks is");

        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i].getName() + "\t" + student[i].getmarks());
        }

        sortString(student);
        System.out.println("Order of students after sorting by student name is");

        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i].getName() + "\t" + student[i].getmarks());
        }
    }
}
class Student
{
    static Comparator<Student> namecomparator=(s1,s2)->s1.getName().compareTo(s2.getName());
    static Comparator<Student> markscomparator=(s1,s2)->Integer.compare(s1.getmarks(),s2.getmarks());
    //the rest of class 
}