import java.util.regex.Pattern;

public class T {

    public static void main(String[] args) {
        String s = "[14:48:51.690] LOGON           error group: 103";

        String[] split = s.split("\\[\\d{1,2}:\\d{1,2}:\\d{1,2}\\.\\d{1,3}\\]\\s*\\w*\\s*");

        System.out.println(split[1]);
    }
}