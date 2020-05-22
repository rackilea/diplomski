public class CgiTest {
public static void main(String[] args) {
String type = "Content-Type: text/html\n\n";
String output = "<html>" +
        "<p>Hi there </p>" +
        "</html>";
System.out.println(type);
System.out.println(output);
}
}