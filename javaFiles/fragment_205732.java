public void printCourseInfo() {
    System.out.println("Course " + name + ", Teacher: " + teacher);
    for (Student stud: studentList) {
        System.out.println(stud);        // Note println instead of print
    }
}