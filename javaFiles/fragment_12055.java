public ArrayList<Student> studentInGrade(String category) {
    ArrayList<Student> gradeCategory = new ArrayList<Student>();
    for (DVD stu : studentList ) {
        if (stu.GetCategory().toUpperCase().contains(category.toUpperCase())) {
            System.out.println("Found");
            gradeCategory .add(dvdEntry);
        }
    }
    return gradeCategory;
}