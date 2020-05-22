import java.util.regex.Pattern;

public class IpCheck {

    public static void main(String[] args) {

        Pattern p = Pattern.compile("^"
                + "(((?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.)+[A-Za-z]{2,6}" // Domain name
                + "|"
                + "localhost" // localhost
                + "|"
                + "(([0-9]{1,3}\\.){3})[0-9]{1,3})" // Ip
                + ":"
                + "[0-9]{1,5}$"); // Port

        System.out.println(p.matcher("1.2.3.4:55555").matches());
        System.out.println(p.matcher("localhost:1").matches());
        System.out.println(p.matcher("google.com:12345").matches());
        System.out.println(p.matcher("1.2.abc:54321").matches());

        System.out.println(p.matcher("1.2.3.4").matches());
        System.out.println(p.matcher("1.2:34").matches());
        System.out.println(p.matcher("local host:12345").matches());
        System.out.println(p.matcher("stackoverflow.com:234.5").matches());
        System.out.println(p.matcher("localhost:65536").matches());

    }

}