public interface Foo {
  Object result();
}

public interface Bar extends Foo {
  @Override
  String result(); // Bar redefines result() to return a String
}