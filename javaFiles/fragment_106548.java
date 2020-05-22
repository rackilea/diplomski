import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.commons.io.FileUtils;

public class Downloader {

    public static void download(String url, String filename) {

        try {

            String base = "http://www.nikaia-hosp.gr/img/";
            if (url.contains("http://www.nikaia-hosp.gr/img/")) {
                FileUtils.copyURLToFile(
                        new URL(base + URLEncoder.encode(url.replace(base, ""), "UTF-8").replaceAll("\\+", "%20")),
                        new File(PropertyReader.readProperty("ExtractedFilesPath") + "/" + filename));
            } else {
                FileUtils.copyURLToFile(new URL(url),
                        new File(PropertyReader.readProperty("ExtractedFilesPath") + "/" + filename));
            }

            try {
                Thread.sleep(Integer.parseInt(PropertyReader.readProperty("downloadTimeout")) * 1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String ar[]) {
        download(
                "http://www.nikaia-hosp.gr/img/ΤΕΛΙΚΕΣ ΠΡΟΔΙΑΓΡΑΦΕΣ ΓΙΑ ΥΠΕΡΗΧΟ ΓΥΝΑΙΚΟΛΟΓΙΚΟ ΜΑΙΕΥΤΙΚΟ ΠΡΟΓΕΝΝΗΤΙΚΟΥ ΕΛΕΓΧΟΥ.pdf",
                "stupid.pdf");
    }
}