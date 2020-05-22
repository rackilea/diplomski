package resourceTest;

import java.io.InputStream;
import org.apache.commons.io.IOUtils;

public class ResourceTestMain {

    public static void main(String[] args) {
        try (InputStream is = ResourceTestMain.class.getClassLoader().getResourceAsStream("resources/script.sql")) {
            String toStringValue = is.toString();
            String contents = IOUtils.toString(is, "UTF-8");
            is.close();
            System.out.println("is.toString() returned:");
            System.out.println("    " + toStringValue);
            System.out.println();
            System.out.println("IOUtils.toString(is, \"UTF-8\") returned:");
            System.out.println("    " + contents);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}