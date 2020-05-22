// Test.java:
class Generic<T> {
}

class Main {

  public static void main(String[] args) {

     final Generic<Integer> gint1 = new Generic<Integer>();

     System.err.println("gint1's type-parameter: " 
                       + gint1.getClass().getTypeParameters()[0]);
  }
}