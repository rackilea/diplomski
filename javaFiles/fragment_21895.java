import java.awt.*;
import javax.swing.*;
import javax.swing.text.DefaultHighlighter;

public class TextAreaLine
{
    public static void main(String[] args) throws Exception
    {
        String string = "Lorem ipsum eum putant gubergren evertitur in, no assueverit vituperatoribus eum. Ea cibo offendit vim, est et vivendum qualisque prodesset. Vis doctus expetenda contentiones an, no ius mazim epicuri expetendis, saperet salutandi forensibus ne usu. Ex fugit alterum usu. His ignota cotidieque in, augue erroribus eam no.";
        JTextArea textArea = new JTextArea(string);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane textAreaScroll = new JScrollPane(textArea);

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(textAreaScroll, BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        String term = "qualisque";
        int termOffset = string.indexOf(term);
        Rectangle view = textArea.modelToView(termOffset);
        int startOffset = textArea.viewToModel(new Point(0, view.y));
        int endOffset = textArea.viewToModel(new Point(textArea.getSize().width, view.y) );
        textArea.getHighlighter().addHighlight(startOffset, endOffset, new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW));
    }
}