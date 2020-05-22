import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;

public class TextFieldUnicode {

  private JScrollPane scrollPane;

  private JTextPane textPane;

  private JTextField textField;

  private Document doc;

  private Highlighter hilit = new DefaultHighlighter();

  private Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(
      Color.GREEN);

  private TextFieldUnicode() throws BadLocationException {
    this.textPane = new JTextPane();
    this.textField = new JTextField();
    this.doc = new DefaultStyledDocument();
    this.scrollPane = new JScrollPane(this.textPane);
    this.textPane.setHighlighter(this.hilit);

    generateSomeText();
    addTextFieldListener();
    createAndShowGUI(this.textField);
  } // end of constructor

  private void generateSomeText() throws BadLocationException {
    for (int i = 0; i <= 50000; i++) {
      doc.insertString(doc.getLength(),
          "hello world, hello stackoverflow, here is some generated text " + i
              + "\n", null);
    }
    textPane.setDocument(doc);
  }

  // here, the text will be highlighter after a search query is inserted
  private void addTextFieldListener() {
    textField.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        paintHighlights();
      }
    });
    textPane.addComponentListener(new ComponentListener() {

      @Override
      public void componentShown(ComponentEvent e) {
      }

      @Override
      public void componentResized(ComponentEvent e) {
      }

      @Override
      public void componentMoved(ComponentEvent e) {
        paintHighlights();
      }

      @Override
      public void componentHidden(ComponentEvent e) {
      }
    });
  }

  private void paintHighlights() {
    float start = System.nanoTime(); // start measuring time

    textPane.getHighlighter().removeAllHighlights();

    String query = textField.getText();
    String text = null;

    JViewport viewport = scrollPane.getViewport();
    Rectangle viewRect = viewport.getViewRect();

    Point p = viewRect.getLocation();
    int startIndex = textPane.viewToModel(p);

    p.x += viewRect.width;
    p.y += viewRect.height;
    int endIndex = textPane.viewToModel(p);

    DefaultStyledDocument document = (DefaultStyledDocument) textPane
        .getDocument();
    try {
      text = document.getText(startIndex, endIndex - startIndex);
    } catch (BadLocationException ex) {
      ex.printStackTrace();
    }

    if (text != null) {
      int index = text.indexOf(query); // get index of word
      int len = query.length(); // get length of word

      while (index >= 0) {
        try {
          textPane.getHighlighter().addHighlight(startIndex + index,
              startIndex + index + len, painter);
        } catch (BadLocationException e) {
          e.printStackTrace();
        }

        index = text.indexOf(query, (index + len));
      }
    }
    float stop = System.nanoTime(); // stop meausuring time
    System.out.println("time=" + (stop - start) / 1000000000 + "s");
  }

  private void createAndShowGUI(JTextField textField) {
    // Create and set up the window.
    JFrame frame = new JFrame("TextFieldDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(textField, BorderLayout.NORTH);
    frame.add(this.scrollPane, BorderLayout.CENTER);
    frame.setSize(new Dimension(600, 600));
    frame.setVisible(true);
  }

  public static void main(String[] args) throws BadLocationException {
    new TextFieldUnicode();
  }
}