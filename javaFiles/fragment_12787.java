$ cat Demo1.java 
class Demo1 {
  public static void main(String[] args) {
    try {
      int[] array = {};
      int impossible = 1/0 + array[0];
    } catch (Exception e) {
      System.out.println("Caught " + e.getClass().getSimpleName());
    }
  }
}

$ cat Demo2.java 
class Demo2 {
  public static void main(String[] args) {
    try {
      int[] array = {};
      int impossible = array[0] + 1/0;
    } catch (Exception e) {
      System.out.println("Caught " + e.getClass().getSimpleName());
    }
  }
}

$ cat Demo3.java 
class Demo3 {
  public static void main(String[] args) {
    try {
      int[] array = {};
      array[0] = 1/0 + array[0]; // assignment happens last
    } catch (Exception e) {
      System.out.println("Caught " + e.getClass().getSimpleName());
    }
  }
}

$ javac Demo*.java

$ java Demo1
Caught ArithmeticException

$ java Demo2
Caught ArrayIndexOutOfBoundsException

$ java Demo3
Caught ArithmeticException