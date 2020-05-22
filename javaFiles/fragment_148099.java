public class Example {
   public static void main(String[] args) throws Exception {
      String str = "hey\u6366";
      byte[] charset = str.getBytes("UTF-8");
      String result = new String(charset, "UTF-8");
      System.out.println(result);
   }
}