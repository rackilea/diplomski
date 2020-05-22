import org.apache.commons.lang.StringEscapeUtils;

public class Escape {

    public static void main(String[] args) {
        System.out.println(StringEscapeUtils.unescapeXml("Arsenal&apos;s trip to Vitoria a &apos;more difficult&apos; test than reverse Europea League tie, warns hosts&apos; coach"));
    }
}