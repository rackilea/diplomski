public class Test {
    public static void main(String[] args) throws Exception {
        Process p = Runtime.getRuntime().exec(
                new String[] {"sh", "-c",
                "less Test.java < "+args[0] + " > "+args[0]});
        System.out.println("=> "+p.waitFor());
    }
}