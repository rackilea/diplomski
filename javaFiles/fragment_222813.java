class Student {
  double height;

  Student(double h) {
    height = h;
  }
}

Map<String, Student> students = ...;

students.put("student 001", new Student(5.01) );

double height = students.get("student 001").height;