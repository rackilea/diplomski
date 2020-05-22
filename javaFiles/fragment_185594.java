import java.awt.Desktop;
import javax.swing.*;
import java.net.*;
import java.io.*;

/** Simplistic example, not intended to show good I/O practices
or Exception handling for the sake of brevity. */
public class Reporter extends JApplet {

    public void init() {
        String input = getParameter("input");

        JEditorPane report = new JEditorPane();
        report.setText("Problem loading input file");
        add(report);

        URL url;
        try {
            url = new URL(getDocumentBase(), input);
            report.setPage(url);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /** The main represents our report generator.  It is part
    of the applet class only in order to create an SSCCE. Good
    design would imply that it might be in a class ReportGenerator,
    while the applet is in class ReportViewer. */
    public static void main(String[] args) throws Exception {
        File f;
        String title = "1";
        String data = "apples";

        createInput(title, data);
        f = createHTML(title);
        Desktop.getDesktop().browse(f.toURI());

        title = "2";
        data = "oranges";

        createInput(title, data);
        f = createHTML(title);
        Desktop.getDesktop().browse(f.toURI());

        System.out.println( "End of report generation.." );
    }

    public static void createInput(String title, String data) throws Exception {
        File f = new File("data" + title + ".txt");
        PrintWriter pw = new PrintWriter(f);
        pw.println(data);

        pw.flush();
        pw.close();
    }

    public static File createHTML(String title) throws Exception {
        File f = new File("Data" + title + ".html");
        PrintWriter pw = new PrintWriter(f);

        pw.println("<html>");
        pw.println("<title>");
        pw.println("Data " + title);
        pw.println("<title>");
        pw.println("<body>");
        pw.println("<h1>");
        pw.println("Data " + title);
        pw.println("</h1>");
        pw.println("<applet ");
        pw.println("code='Reporter'");
        pw.println("width='400'");
        pw.println("height='400'");
        pw.println(">");
        pw.println("<param name='input' value='data" + title + ".txt'>");
        pw.println("</applet>");
        pw.println("</body>");
        pw.println("</html>");

        pw.flush();
        pw.close();

        return f;
    }
}