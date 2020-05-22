package life_ray;

import java.io.File;
import javax.servlet.jsp.JspWriter;

public class OpenDir {

    public static File[] listSamplePictures() {
        File f = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\");
        return f.listFiles();
    }

    public static void printSamplePictures(JspWriter w) {
        File[] files = listSamplePictures();
        for (int i = 0; i < files.length; i++) {
            w.println("<img src=\"" + files[i].getAbsolutePath() + "\" alt=\"\">");
        }
    }

}