import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NSlashes {
    public static void main(String[] args) {
        String string = "abc://axs/abc/def/gh/ij/kl/mn/src/main/resources/xx.xml";
        Matcher m = Pattern.compile( "(?:[^/]*/){8}(.*)/[^/]*").matcher( string );
        if ( m.matches() ) {
            String result = m.group( 1 );
            System.out.println( "result: '"+result+"'" );
        }
    }
}