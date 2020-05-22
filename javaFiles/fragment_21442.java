import java.util.*;
import java.io.*;

public class TestNodeList {
  public static void main(String[] args) {
    // usage: basic initialization
    NodeList nl = new NodeList();
    nl.add(new Node("someUtilObj")); 
    nl.add(new Node("."));
    nl.add(new Node("print"));
    nl.add(new Node("("));
    nl.add(new Node("myIntValue"));
    nl.add(new Node(")"));
    nl.add(new Node(";"));
    nl.print();

    // usage: using the API, moving and peeking
    nl.peekAhead(1).print();
    nl.peekAhead(2).print();
    nl.peekAhead(3).print();
    nl.moveAhead(2).print();
    nl.getCurrentNode().print();
    nl.peekBack(2).print();
  }
}