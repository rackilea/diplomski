# code taken from: 
# "Print Unicode characters to the Terminal with Java",
# http://hints.macworld.com/article.php?story=20050208053951714

echo '
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
class Test {
  public static void main (String[] argv) throws UnsupportedEncodingException {
  String unicodeMessage = "\u00b2\u2591\u2592\u2593";
  PrintStream out = new PrintStream(System.out, true, "UTF-8");
  out.println(unicodeMessage);
  }
}
' > test.java

javac test.java
java Test