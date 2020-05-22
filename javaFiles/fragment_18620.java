public class Test {
    public static void main(String[] args) {
    String currentString[] = "0|1|2|3|4|5|6|7|8||".split("\\|", -1);
    System.out.println("Length:"+currentString.length); 
    for(int i=0;i < currentString.length;i++){ System.out.println(currentString[i]); }
  }
}