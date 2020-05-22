public List<Student> getStudentInfo(
                     BiConsumer<FailedToFetchDataException, Student> handleError) {
    //Contains some static info like name, dob of a Student
    List<Student> students = getStudentStaticInfo();
    for (Student student: students) {
        try{
            student.setTotalMarks(getStudentMark(student.getId()));
            ...
        } catch(FailedToFetchDataException e) {
            handleError.accept(e, student);
        }
    }
    return students;
}