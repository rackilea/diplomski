import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegEx {
    public static void main(String[] args) {
        String s = "Windows Server 2008 datacenter";
        String r = "(?i)Win\\w*\\s*Server\\s*(2008)(?!\\sR2).*?$";
        Pattern p = Pattern.compile(r);
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}