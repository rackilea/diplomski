Iterator<StudentObj> students;

synchronized StudentObj getStudentInfo() {
    if (null == students || !students.hasNext()) {
        students = StudentDAO.getRows().iterator();
    }
    return students.next();
}