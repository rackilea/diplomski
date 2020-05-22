package jfunc;

import java.util.function.*;

public class Acceptor {
  public void f(Function<String, Void> g) { g.apply("hello, world."); }
}