public class JavaFiddle {

  static String s = "   1   0   3        150.00";

  public static void main(String[] args) {
      String[] split = s.trim().split("\\s+");
      for(int i=0; i < split.length; i++){
      System.out.println(i + "-->" + split[i]);    
      }     
  }
}