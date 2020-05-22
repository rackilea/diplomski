private void studendAndDiscipline(String[] details) {
    int studentId=Integer.parseInt(details[1]);
    int disciplineId=Integer.parseInt(details[2]);
    Student student=repository.findById(studentId);
    Discipline discipline=repository1.findById(disciplineId);
    student.addDiscipline(discipline);
}