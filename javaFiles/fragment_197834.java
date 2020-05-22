Student student=repository.findById(studentId).get();
Discipline discipline=repository1.findById(disciplineId).get();
if (discipline != null) {
    student.addDiscipline(discipline);
    System.out.println("Adding discipline to student.");
}