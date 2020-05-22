public class A {
    public static void main(String[] args) {
      StringBuilder sb = new StringBuilder();
      sb.append("abcdefg");
      System.out.println("String is [" +sb + "]");
      sb.replace(0,0,"");
      System.out.println("String is [" +sb + "]");
      sb.replace(0,1000,"");
      System.out.println("String is [" +sb + "]");
    }
}