public class TestClass {
  PrintWriter output;
  public void write(String currentLine) {
    output.println(currentLine);
  }

  public static void main(String[] args) {
    TestClass tc = new TestClass();
    tc.output = new PrintWriter(new FileWriter(args[1]));
    tc.write("Sometext");
  }
}