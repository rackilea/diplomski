public class Foo {
  static int[][] arr;
  public static void bar() {
    arr = new int[20][20];

    System.out.println("Before: " + arr[1][1]);
    // in the second run of Foo.bar(), the value of arr[1][1] is already 1
    // before executing the next statement!
    arr[1][1] = 1;
    System.out.println("After: " + arr[1][1]);
  }

  public static void main(String[] args) {
    bar();
    bar();
  }
}