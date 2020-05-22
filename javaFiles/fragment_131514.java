while ( (inputLine = input.readLine() ) != null ) {
      Teacher teacher = new Teacher(teacherVar[0], teacherVar[1], teacherVar[2]);
      Course aCourse = new Course(teacherVar[3], teacherVar[4]);

      teacher.getCourses().add(aCourse);
}