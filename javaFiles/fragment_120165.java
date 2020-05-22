import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class Demo {

    private void initGUI(){

        final JTextArea textArea = new JTextArea();

        textArea.addCaretListener(new CaretListener() {            
            @Override
            public void caretUpdate(CaretEvent e) {
                if(e.getMark() == e.getDot()){
                    Highlighter hl = textArea.getHighlighter();
                    hl.removeAllHighlights();

                    String pattern = "<aa>";
                    String text = textArea.getText();        
                    int index = text.indexOf(pattern);
                    while(index >= 0){
                        try {                
                            Object o = hl.addHighlight(index, index + pattern.length(), DefaultHighlighter.DefaultPainter);
                            index = text.indexOf(pattern, index + pattern.length());
                        } catch (BadLocationException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(300,200));

        JPanel content = new JPanel(new FlowLayout());
        content.add(scrollPane);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(content);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);        
    }


    public static void main(String[] args) {        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().initGUI();
            }
        });
    }

}