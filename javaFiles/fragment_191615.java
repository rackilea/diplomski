@Data
public class Score {
  private long grade;

  public void setGrade(long grade) {
    this.grade = grade + 1;
  }
}