import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Remove {

    public static void main(String[] args) {
        String s="[From:14 02 1986,To:14 02 2016]";

        Pattern r = Pattern.compile("From:(\\d\\d \\d\\d \\d\\d\\d\\d),To:(\\d\\d \\d\\d \\d\\d\\d\\d)");

        Matcher m = r.matcher(s);
        if (m.find( )) {
            System.out.println("From date : " + m.group(1) );
            System.out.println("To date   : " + m.group(2) );
        }else {
            System.out.println("NO MATCH");
        }


    }

}