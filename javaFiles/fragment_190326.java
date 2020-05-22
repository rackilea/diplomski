protected int lastItem = 0;

protected Score[] scores = new Score[100]; //any initial size

public void addScore(Score score) {
  scores[lastItem++] = score;
  //check if you need to make the array larger
  //maybe copying elements with System.arraycopy()
}