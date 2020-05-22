import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Path {

    static Pattern pv=Pattern.compile("\\$\\{(\\w+)\\}");

    /*
     * os.path.expanduser
     */
    public static String expanduser(String path) {
        String user=System.getProperty("user.home");

        return path.replaceFirst("~", user);
    }//expanduser

    /*
     * os.path.expandvars
     */
    public static String expandvars(String path) {
        String result=new String(path);

        Matcher m=pv.matcher(path);
        while(m.find()) {
            String var=m.group(1);
            String value=System.getenv(var);
            if (value!=null)
                result=result.replace("${"+var+"}", value);
        }
        return result;
    }//expandvars


}///