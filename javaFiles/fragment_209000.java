import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegEx {
    public static void main(String[] args) {
        String s = "dsfdsdafd,safdsa,gfdsgdtheMatchfdsgfd,dsafdsa";
        String r = "[^,]+theMatch.*?(?=,)";
        Pattern p = Pattern.compile(r);
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());  // gfdsgdtheMatchfdsgfd
        }
    }
}