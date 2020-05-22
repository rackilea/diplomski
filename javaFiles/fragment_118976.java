public static void main(String[] args) {
    Scanner in = new Scanner(System.in); //input object
    int numCourses; //number of courses - can be changed
    int credits;        //number of credits for a course
    String grade;       //grade for course

    //read in number of courses
    System.out.print("Enter number of courses: ");
    numCourses = in.nextInt();

    //create Gpa object to hold specified number of courses
    Gpa t = new Gpa(numCourses);

    //read in all courses and add course information to Gpa object
    for (int k=0; k<numCourses; k++)
    {
        System.out.print("Enter credits for course " + (k+1) + ": ");
        credits = in.nextInt();
        System.out.print("Enter grade for course " + (k+1) + ": ");
        grade = in.next();

        t.addGrade(grade, credits);
    }

    //print results
    System.out.println();
    System.out.printf("GPA is %4.2f%n", t.getGpa()); 
}