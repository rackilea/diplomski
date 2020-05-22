import java.util.regex.*;
class Test {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("<[b|B]>(.*)</[b|B]>");
        Matcher m = p.matcher(args[0]);
        if (m.find()) {
            System.out.println(m.group(1));
        }
        else System.out.println("No match");
    }
}