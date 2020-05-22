public class Things {
  List<Ball> ballList = new LinkedList<>();

  public void addBall(Ball b){
    ballList.add(b);
  }
}

public class A {
  private Things field;

  public A(Things field){
    this.field = field;
  }

  public void add(int size){
    field.addBall(new Ball(size));
  }
}