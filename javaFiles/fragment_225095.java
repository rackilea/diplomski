public class Example {
 public static final Example ex1 = new Example("__EX_1__");
 public static String DEFAULT_NAME = "Paulo"; // <-- change 1

 private String name;

 static {
     System.out.println("Class inited");  // <-- change 2
 }

 public Example(String name) {
     this.name = name;
 }
}