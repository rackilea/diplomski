import java.awt.ComponentOrientation;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;

public class MyFormattedOuputSolutionOne extends javax.swing.JFrame {

    private MyFormattedOuputSolutionOne() {
        super("MyFormattedOuputSolutionOne");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        final JEditorPane myFormattedOuput = new javax.swing.JEditorPane();

        getContentPane().add(jScrollPane1);

        myFormattedOuput.setContentType("text/html");
        //myFormattedOuput.setContentType("text/html; charset=UTF-8"); //Doesn't seem to work

        myFormattedOuput.setEditable(false);

        jScrollPane1.setViewportView(myFormattedOuput);

        myFormattedOuput.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        try{
            myFormattedOuput.setPage(getClass().getResource("htmlFormatTable.html"));
            myFormattedOuput.addPropertyChangeListener(new PropertyChangeListener() {

                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if ("page".equals(evt.getPropertyName())) {
                        Document doc = myFormattedOuput.getDocument();
                        Element html = doc.getRootElements()[0];
                        Element body = html.getElement(1);
                        Element table = body.getElement(1);
                        try {
                            Element tr2 = table.getElement(1);
                            Element tr2td1 = tr2.getElement(0);
                            doc.insertString(tr2td1.getStartOffset(), "1: 123,456",
                                             SimpleAttributeSet.EMPTY);

                            Element tr3 = table.getElement(2);
                            Element tr3td1 = tr3.getElement(0);
                            doc.insertString(tr3td1.getStartOffset(), "2: 765.123",
                                             SimpleAttributeSet.EMPTY);
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                        myFormattedOuput.removePropertyChangeListener(this);
                    }
                }

            });

            //How can I edit/change html elements loaded in 'myFormattedOuput'?

        } catch(Exception e){
            e.printStackTrace();
        }

        pack();
        setSize(700, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFormattedOuputSolutionOne();
            }
        });
    }
}