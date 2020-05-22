public List<Student> getAllStudents() throws SQLException {
    List<Student> students = new ArrayList<Student>();

    String select = "SELECT * FROM students";
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(select);

    while ( resultSet.next() ) {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        int age = resultSet.getInt(3);

        Student student = new Student(id, name, age);
        students.add(student);
    }

    return students;
}