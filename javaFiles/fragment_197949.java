public class Test {
  public static void main(String[] args) {
     String input = "hello my name is roger";
     input+=' '; // adding a whitespace at end to indicate completion of last word

     String word = "";
     char ch;
     String res = "";
     int len = input.length();

     for(int i = 0;i<len ;i++) {
       ch = input.charAt(i);
       if(Character.isWhitespace(ch)) {
         res = res +" "+processWord(word);
         System.out.println(word);
         word = "";
       }else {
         word+=ch;
       }
     }
}

  private static String processWord(String word) {
    // TODO Auto-generated method stub
    if(word.length()<=2) {
      return word;
    }

    // do whatever you have to do with your word
    String res = "";
    return res;
  }
}