public class JavaMain {
  public static void main(String[] args) {

    // Use the Java API in your Java application
    // Notice that now all A_j's and B_j's are
    // pure Java interfaces, so that nothing 
    // should go wrong.
    A_j a = JavaApi.createA(); // the only call of a Scala-method.
    B_j<String> b = a.createB("foobarbaz");
    System.out.println(b.superImportantMethod());
  }
}