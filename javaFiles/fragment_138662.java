package com.dummy.foo;

import com.dummy.hello.Hello;

public class Main {
  public static void main(String[] args) {
    System.out.print("mixing java and scala");
    Foo foo = new Foo();
    foo.foo();
    new Hello().hello();
  }
}