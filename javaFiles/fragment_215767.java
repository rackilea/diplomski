import java.io.*;
import java.net.*;
import java.util.regex.*;
import javax.swing.*;


public class webloader {
    static JComponent page;
    public static void loadcode(){
        JEditorPane jep = new JEditorPane();
         jep.setEditable(false);   

         try {
           jep.setPage("http://(server):(port)/" + web.url);
         }
         catch (IOException e) {
           jep.setContentType("text/html");
           jep.setText("<html>Could not load webpage</html>");
         } 

         JScrollPane scrollPane = new JScrollPane(jep);     
         JFrame f = new JFrame(web.url);
         f.getContentPane().add(scrollPane);
         f.setSize(512, 342);
         f.show();
    }
}