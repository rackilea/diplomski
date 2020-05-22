import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;

class Test {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JEditorPane edPane = new JEditorPane(); 

        try {

            edPane.setContentType("text/html");

            System.out.println(edPane.getText());

            HTMLEditorKit hek = new HTMLEditorKit();

            edPane.setEditorKit(hek);

            HTMLDocument doc = (HTMLDocument) edPane.getDocument();

            doc.insertString(0, "Test testing", null);

            Element[] roots = doc.getRootElements();
            Element body = null;
            for( int i = 0; i < roots[0].getElementCount(); i++ ) {
                Element element = roots[0].getElement( i );
                if( element.getAttributes().getAttribute( StyleConstants.NameAttribute ) == HTML.Tag.BODY ) {
                    body = element;
                    break;
                }
            }

            doc.insertAfterEnd(body,"<img src="+ClassLoader.getSystemResource("thumbnail.png").toString()+">");
            System.out.println(edPane.getText());
        } catch(BadLocationException e) {
        } catch (java.io.IOException e) {}


        frame.add(edPane);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}