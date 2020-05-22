class MyFoo implements Comparable<MyFoo> {
  private String name;
  private int score;

  public MyFoo(String name, int score) {
     // ... etc...
  }

  // getter methods here

  public int compareTo(MyFoo other) {
    return score - other.getScore();
  }

  //.... etc...
}