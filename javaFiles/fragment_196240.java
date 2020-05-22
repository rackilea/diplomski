package test;

import bsh.Interpreter;

public class Main {

  public static void foo(Object param) {
    System.out.println("From Java, param=" + param);
  }

  public static void main (String[] args) throws Exception {

    Interpreter i = new Interpreter();
    i.eval("a = 3 * 5; test.Main.foo(a);");
  }
}