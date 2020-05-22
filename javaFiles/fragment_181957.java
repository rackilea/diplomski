import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class Image{

    public static void main(String[] args) throws Exception {
        String s = FileUtils.readFileToString(new File(
                "E:\\workspace\\XYZ\\src\\xpath.txt"));

        Pattern p = Pattern.compile(
                "(.*?)(<img)(.*?)(src=\")(.*?)(\")(.*?)(\\/>)(.*?)",
                //                       ^^^^^
                // 1     2    3     4      5   6    7    8     9
                Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(s);
        while (m.find()) { //use while to find all images, and if for only the first one
            System.out.print(m.group(5));
        }
    }
}