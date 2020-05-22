import java.util.regex.*;

public class Test {

    public static void main(String[] args) {

        String src = "abc :  def";   // two spaces after colon.
        String tgt = "ghi :   jkl";  // three spaces after colon.

        Pattern spaces = Pattern.compile("([^:]*:)(\\s*)(.*)");

        Matcher mSrc = spaces.matcher(src);
        Matcher mTgt = spaces.matcher(tgt);

        mSrc.matches();
        mTgt.matches();

        System.out.println("Spaces in src: " + mSrc.group(2).length());
        System.out.println("Spaces in tgt: " + mTgt.group(2).length());

        System.out.println("Target with src's number of spaces: " +
                           mTgt.group(1) + mSrc.group(2) + mTgt.group(3));
    }
}