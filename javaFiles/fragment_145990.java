// find the highest grade in each class
ArrayList<Student> highestInEachClass = new ArrayList<>();
for (Classroom classroom : school) {
    highestInEachClass.add(classroom.getHighestGradeStudent());
}

// find the highest grade overall
Student highestGradeStudent = highestInEachClass.get(0);
for (Student student : highestInEachClass) {
    if (highestGradeStudent.getFinalGrade() < student.getFinalGrade()) {
        highestGradeStudent = student;
    }
}
return highestGradeStudent;