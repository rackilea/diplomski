StudentManager engineering = new StudentManager(engineeringList);
StudentManager gradStudents = new StudentManager(gradStudentList);

Student s = getCorsika(); // that's me!!!
engineering.getStudent(s.getCode()); // finds me, because I'm an engineer
gradStudents.getStudent(s.getCode()); // doesn't find me, because I'm not a grad student