String[] students = ...
double[] averages = new double[students.length];

for (int i = 0; i < students.length; i++) {
    String[] student = students[i].split(",");
    int sum = 0;

    for (int j = 4; j < student.length; j++) {
        sum += Integer.parseInt(student[j]);
    }

    averages[i] = (double) sum / (student.length - 4);
}