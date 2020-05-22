public class Student {
  private String name;
  private int[] grades;

  public Student(String name) {
    this.name = name;
    this.grades = new int[10];
  }

  public void setGrade(int assignmentNumber, int grade) {
    grades[assignmentNumber] = grade;
  }

  public int[] getGrades() {
    return grades;
  }
}