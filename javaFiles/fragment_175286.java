import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class TextAreaHighlighting extends JPanel
{
    private JTextArea textPane = new JTextArea(10, 30);
    private DefaultHighlighter highlighter =  (DefaultHighlighter)textPane.getHighlighter();

    private Highlighter.HighlightPainter cyanPainter;
    private Highlighter.HighlightPainter yellowPainter;

    public TextAreaHighlighting()
    {
        setLayout( new BorderLayout() );

        textPane.setText( "one\ntwo\nthree\nfour\nfive\nsix\nseven\neight\nnine\nten" );
        add( new JScrollPane( textPane ) );

        //  Highlight some text

        highlighter.setDrawsLayeredHighlights(false);

        cyanPainter = new DefaultHighlighter.DefaultHighlightPainter( Color.CYAN );
        yellowPainter = new DefaultHighlighter.DefaultHighlightPainter( Color.YELLOW );

        try
        {
            highlighter.addHighlight( 0, 3, cyanPainter );
        }
        catch(BadLocationException ble) {}

        JPanel buttons = new JPanel();
        add(buttons, BorderLayout.PAGE_END);

        JButton addHighlight = new JButton("Highlight Selected");
        buttons.add(addHighlight);
        addHighlight.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    int start = textPane.getSelectionStart();
                    int end = textPane.getSelectionEnd();

                    highlighter.addHighlight( start, end, yellowPainter );
                }
                catch(BadLocationException ble) {}
            }
        });

        //  Add Remove Highlight button

        JButton removeHighlight = new JButton("Remove Selected Highlight");
        buttons.add( removeHighlight );
        removeHighlight.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int start = textPane.getSelectionStart();
                int end = textPane.getSelectionEnd();

                Highlighter.Highlight[] highlights = textPane.getHighlighter().getHighlights();

                for (int i = 0; i < highlights.length; i++)
                {
                    Highlighter.Highlight h = highlights[i];
                    DefaultHighlighter.DefaultHighlightPainter thePainter =
                        (DefaultHighlighter.DefaultHighlightPainter)h.getPainter();

                    if (h.getStartOffset() >= start
                    &&  h.getEndOffset() <= end)
                        highlighter.removeHighlight(h);
                }
            }
        });

    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("Text Pane Highlighting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TextAreaHighlighting());
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }
}