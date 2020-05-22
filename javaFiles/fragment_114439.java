import java.nio.charset.*;

class Some{

public static void main(String args[]) 
 {
final Charset cs = Charset.forName("GB2312");
final CharsetEncoder encode = cs.newEncoder();
System.out.println(encode.canEncode("ダチヂッツヅテデ")); 
 }

}