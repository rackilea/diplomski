public static void print_all() {

    System.out.println("Student ID\tRecent Grades\tName\t\tE-Mail\t\t\tAge");
    for (Student w : studentlist) {
        System.out.print(w.getStudentID() + "\t\t");
        System.out.print(w.getGrades() + "\t");
        System.out.print(w.getFirstname()+ " ");
        System.out.print(w.getLastname()+ "\t");
        System.out.print(w.getEmail()+ "\t");
        System.out.print(w.getAge()+ "\t");
        System.out.println(" ");
    }
}