import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CheckForUpdate {

    public static void main(String[] args) throws IOException {
        ImageIcon updateicon = new ImageIcon("resources/update.png");
        String url = "http://example.com/wp-content/uploads/version/Version.html";
        Document document = Jsoup.connect(url).get();
        String getcurrentversion = document.select("version").first().text();  
        int intcurrentversion = Integer.parseInt(getcurrentversion);    
        System.out.println(intcurrentversion);

        if (intcurrentversion > 0) {

            int response = JOptionPane.showConfirmDialog(null, "Would you like to update?", "Update available!",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,updateicon);

            if (response == JOptionPane.NO_OPTION) {
                System.out.println("No button clicked");
            } else if (response == JOptionPane.YES_OPTION) {
                System.out.println("Yes button clicked");

                {
                    String filePath = "C:/Windows/Updater.exe";//
                    try {
                        Process p = Runtime.getRuntime().exec(filePath);

                    } catch (Exception g) {
                        g.printStackTrace();
                    }
                }


            } else {
                JOptionPane.showMessageDialog(null,"Currently no updates available!!");

            }
        }
    }
}