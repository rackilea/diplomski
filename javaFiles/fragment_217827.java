import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.io.*;

public class TestTextArea {

    public static void main(String[] args) {
        new TestTextArea();
    }

    public TestTextArea() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestTextAreaPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestTextAreaPane extends JPanel {

        private JTextArea textArea;

        public TestTextAreaPane() {
            setLayout(new BorderLayout());
            textArea = new JTextArea(20, 100);
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);

            try
            {
                FileReader reader = new FileReader( "TestTextArea.java" );
                BufferedReader br = new BufferedReader(reader);
                textArea.read( br, null );
                br.close();
            }
            catch(Exception e2) { System.out.println(e2); }

            JScrollPane scrollPane = new JScrollPane(textArea);
            add(scrollPane);
            scrollPane.getViewport().addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    if (textArea.getText().length() > 0) {
                        JViewport viewport = (JViewport) e.getSource();
                        Rectangle viewRect = viewport.getViewRect();

                        Point p = viewRect.getLocation();
                        int startIndex = textArea.viewToModel(p);

                        int lineHeight = textArea.getFontMetrics( textArea.getFont() ).getHeight();
                        p.y += viewRect.height - lineHeight;
                        int endIndex = textArea.viewToModel(p);

                        Element root = textArea.getDocument().getDefaultRootElement();
                        int startLine =  root.getElementIndex( startIndex );
                        int endLine =  root.getElementIndex( endIndex );
                        int lines = endLine - startLine + 1;
                        System.out.println(lines);
                    }
                }
            });
        }
    }
}