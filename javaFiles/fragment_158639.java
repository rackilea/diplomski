package jvmtest;

import java.io.Console;
import jvmtest.MyClass;

public class JVMTest {
  public static void main(String[] args) {
    System.out.println("JVMTest started ...");

    Console c = System.console();
    String enter = c.readLine("Press Enter to proceed");
    MyClass myClass = new MyClass();
    System.out.println("Bye Bye");
  }
}