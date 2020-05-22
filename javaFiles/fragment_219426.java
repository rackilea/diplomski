import java.util.regex.*;
public class regex1{
public static void main(String args[]){
    String s1 = "cat catches dog text";
    Pattern p1 = Pattern.compile("\\s*cat\\s+catches\\s*dog\\s+(\\S+)");
    Matcher m1 = p1.matcher(s1);
    if (m1.find()){
        System.out.println(m1.group(1));
        s1 = s1.replaceFirst(m1.group(1),"variable");
        System.out.println(s1);
    }
    else{
        System.out.println("Else");
    }
}
}