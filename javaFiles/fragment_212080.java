public class Escaping {

private static final String COLON = ":";
private static final String ESCAPE_COLON = ".colon.";

public static void main(String args[]) {
    String str = "This is my : String : with colons"; 
    String escapedStr = str.replaceAll(COLON,ESCAPE_COLON);
    System.out.println(escapedStr);
    // perfrom whatever action you need with the 'problematic' colon characters
    // ...
    // ...
    System.out.println(escapedStr.replaceAll(ESCAPE_COLON,COLON));
    }
}