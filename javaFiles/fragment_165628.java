import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
import javax.swing.*;

public class TextAreaOutputStreamTest {
  private final JTextArea consoleOutput = new JTextArea();
  private final JTextField textField = new JTextField();

  public JComponent makeUI() {
    try {
      OutputStream os = new TextAreaOutputStream(consoleOutput);
      System.setOut(new PrintStream(os, true, "UTF-8"));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    Box box = Box.createHorizontalBox();
    box.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    box.add(Box.createHorizontalGlue());
    box.add(textField);
    box.add(Box.createHorizontalStrut(5));
    box.add(new JButton(new AbstractAction("Enter") {
      @Override public void actionPerformed(ActionEvent e) {
        String s = new Date().toString();
        System.out.println(s + "\n    " + textField.getText());
      }
    }));
    consoleOutput.setEditable(false);

    JPanel p = new JPanel(new BorderLayout());
    p.add(new JScrollPane(consoleOutput));
    p.add(box, BorderLayout.SOUTH);
    return p;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new TextAreaOutputStreamTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}

class TextAreaOutputStream extends OutputStream {
  private final ByteArrayOutputStream buf = new ByteArrayOutputStream();
  private final JTextArea consoleOutput;
  public TextAreaOutputStream(JTextArea consoleOutput) {
    super();
    this.consoleOutput = consoleOutput;
  }
  @Override public void flush() throws IOException {
    consoleOutput.append(buf.toString("UTF-8"));
    buf.reset();
  }
  @Override public void write(int b) throws IOException {
    buf.write(b);
  }
}