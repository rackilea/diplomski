import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FolderDemo {

    public static void writeRequestAndResponse() {

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH.mm.ss");

        String currentDateTime = format.format(date);

        String folderPath = "F:\\working\\POC\\Output\\" + "LastRunOn_"
                + currentDateTime;

        File theDir = new File(folderPath);

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("creating directory: " + theDir.getName());
            boolean result = false;

            try {

                theDir.mkdirs();
                result = true;
            } catch (SecurityException se) {
                // handle it
                System.out.println(se.getMessage());
            }
            if (result) {
                System.out.println("Folder created");
            }
        } else if (theDir.exists()) {

            System.out.println("Folder exist");
        }

    }

    public static void main(String[] args) {
        writeRequestAndResponse();
    }

}