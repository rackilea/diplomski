public class Main {

    public static class Student {
        String name;
        int grade;
        double average;

        public Student()
        {
            name = "Nothing";
            grade = -1;
            average = 0.0;
        }

        public void PrintStudent()
        {
            System.out.println("[" + name + ", " + grade + ", " + average + "]");
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Student [] students = null;
        System.out.print("Enter How Many Students to Create: ");
        String numberOfStudents = in.nextLine();

        if(numberOfStudents.matches("\\d+"))
        {
            students = new Student [Integer.parseInt(numberOfStudents)];
        }
        else 
        {
            System.err.println("Error when reading user input, exiting...");
            return;
        }

        CreateStudents(students, in);
        PrintStudents(students);


    }//main method

    public static void CreateStudents(Student[] allStudents, Scanner inputOrigin)
    {
        System.out.println("Enter Students as CSV(Comma Seperated Values).\nExample Given: Pete The Dragon, 11, 3.67");
        for(int studentIndex = 0; studentIndex < allStudents.length; studentIndex++)
        {
            System.out.println("Enter information for student #" + studentIndex + ": ");
            String[] input = inputOrigin.nextLine().split(",");
            try{
                //note how each index is a value of the student object in the input string array
                Student newStudent = new Student();
                newStudent.name = input[0];
                newStudent.grade = Integer.parseInt(input[1].replaceAll(" ", ""));
                newStudent.average = Double.parseDouble(input[2].replaceAll(" ", ""));
                allStudents[studentIndex] = newStudent;
            }
            catch(Exception ex)
            {
                System.err.println("Failed to create the " + studentIndex + " due to the following:" + ex.toString());
                allStudents[studentIndex] = new Student();
                    //or we can terminate 
                //return;
            }
        }
    }

    public static void PrintStudents(Student[] allStudents)
    {
        System.out.println("The students are as follows:");
        for(int index = 0; index < allStudents.length; index++)
        {
            System.out.print(index + ": ");
            if(allStudents[index] != null)
                allStudents[index].PrintStudent();
        }
    }
}