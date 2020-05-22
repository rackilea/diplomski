private static int MAX_SCORES = 3;
private SortedSet<Score> scores = new TreeSet<Score>();

public Set<Score> getScores() {
  return scores;
}

public void addScore(String name, int score) {
  scores.add(new Score(name, score));
  while (scores.size() > MAX_SCORES) {
    scores.remove(scores.first());
  }
}

private class Score implements Comparable<Score> {
  private String name;
  private int score;

  private Score(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public int compareTo(Score obj) {
    if (this == obj) {
      return 0;
    }
    if (this.score < obj.score) {
      return -1;
    } else if (this.score > obj.score) {
      return 1;
    }
    return name.compareTo(obj.name);
  }

  public String toString() {
    return name + " - score = " + score;
  }
}