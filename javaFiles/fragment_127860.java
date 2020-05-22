import javax.swing.*;

public class HTMLFromString {

    HTMLFromString() {
        JEditorPane jep = new JEditorPane();

        String html = "<html><body><h1>Title</h1><p>Paragraph..";
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