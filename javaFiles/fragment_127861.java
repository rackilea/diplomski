import javax.swing.*;

public class HTMLFromString {

    static String SNIPPET = 
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional" +
            "//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head>" +
            "<meta http-equiv=\"Content-Type\" content=\"text/html; " +
            "charset=Windows-1252\" /><title></title>" +
            "<style type=\"text/css\">" +
            "a, a:visited" +
            "{" +
            "  color: #406377;" +
            "}" +
            "</style>" + 
            "</head>" +
            "<body bgcolor=\"#ffffff\" style=\"background-color: #ffffff; " +
            "width: 600px; font-family: Arial, Verdana, Sans-serif; color: " +
            "#000; font-size: 14px; margin: 0px;\"><h1>Hi!</h1>";

    HTMLFromString() {
        JEditorPane jep = new JEditorPane();

        String html = "<html>" + SNIPPET;
        // Important!
        jep.setContentType("text/html");
        jep.setText(html);

        JOptionPane.showMessageDialog(null, jep);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new HTMLFromString();
            }
        });
    }
}