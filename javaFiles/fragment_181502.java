import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain {
    public static void main(String[] args) {
        Pattern cdef = Pattern.compile("^#[\\t ]*define[\\t ]+(\\w+)[\\t ]*(.*)(\\/\\*.*\\*\\/)", Pattern.DOTALL);
        Matcher matcher = cdef
                .matcher("#define KERNEL_VERSION(a,b,c) ((a)*65536+(b)*256+(c)) /* We're doing kernel work */");
        System.out.println(matcher.matches());
        for (int n = 0; n <= matcher.groupCount(); n++)
            System.out.println(matcher.group(n));
    }
}