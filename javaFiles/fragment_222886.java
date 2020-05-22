public class SystemAdministration
{
     public static ArrayList<StudentCounselor> studentCounselors = new ArrayList<StudentCounselor>();

     public static void addStudentCounselor(User student, User counselor)
     {
         //  Check to see first that the student-counselor combo doesn't exist

         studentCounselors.addItem(student, counselor);
         // addItem may not be the precise name of the function in ArrayList.
     }

     // function to obtain all students of a counselor
     public static ArrayList<User> getStudentsOfCounselor(User counselor)
     {
         // iterate through the studentCounselors ArrayList and pick only
         // the Student-Counselor whose counselor is the same counselor
         // as the one passed into this function.
         // Then extract the student property out of the fitting 
         // Student-Counselor.
         // Return the list of students. 
     }

     public static ArrayList<User> getCounselorsOfStudent(User student)
     {
         // Similar as above, but the other way around.
     }

}