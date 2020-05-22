import java.util.regex.*;

public class HelloWorld {

    public static void main(String[] args) {
        String line = "{abc} say hello to {def};";

        Matcher m = Pattern.compile("^\\{([^}]*)\\}(.*)\\{([^}]*)\\};$").matcher(line);
        if (m.find()) {
            System.out.println("first Id: " + m.group(1));
            System.out.println("second Id: " + m.group(3));
            System.out.println("replaced String: " + "Peter" + m.group(2) + "Sally");
        }
    }
}