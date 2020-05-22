@Data
public class Score {
  private long grade;

  public long getGrade() {
    return this.grade + 1;
  }
}