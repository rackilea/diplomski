public class TestJarPath {
    public static void main(String args[]) throws Exception {
        for (String s : args)
         System.out.print("[" + s + "] ");
        System.out.println();

        String cp = System.getProperty("java.class.path");
        for (String s : cp.split(";"))
          System.out.println(s);
    } 
}