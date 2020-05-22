public static void main(String[] args) throws IOException {

    // read all the lines of your file
    List<String> lines = Files.readAllLines(Paths.get("info1.txt"));

    // first line is the number of exams
    int nbExams = Integer.valueOf(lines.get(0).trim());

    // remove first line, now each line is a student
    lines.remove(0);
    int nbStudents = lines.size();

    Student[] students = new Student[nbStudents];
    for(int iStudents = 0; iStudents<nbStudents; iStudents++) {
        String line = lines.get(iStudents);

        // split your line on spaces
        String[] tokens = line.split(" ");

        // first is name
        String studentName = tokens[0];

        // next are studentGrades
        int[] grades = new int[nbExams];
        for(int i=0; i<nbExams; i++) {
            grades[i] = Integer.valueOf(tokens[i+1]);
        }

        students[iStudents] = new Student(studentName, grades);
    }

    System.out.println(Arrays.toString(students));
}