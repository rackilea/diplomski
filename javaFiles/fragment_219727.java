public class Person implements Comparable<Person> {

  private String name;
  private double score;

  public Person(final String name, final double score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
      return name;
  }

  public void setName(final String name) {
      this.name = name;
  }

  public double getScore() {
      return score;
  }

  public void setScore(final double score) {
      this.score = score;
  }

  @Override
  public int compareTo(final Person another) {
      return Double.compare(score, another.score);
  }
}