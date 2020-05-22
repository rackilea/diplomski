import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TextPaneDemo {
  static void addIt(JTabbedPane tabbedPane, String text) {
    JPanel panel = new JPanel();
    JTextPane ta = new JTextPane();
    ta.setContentType("text/html");
    ta.setText("<HTML><BODY><CODE> import java.io.*; <br> public class MyIO{}</CODE><br></BODY></HTML>");
    JScrollPane jsp = new JScrollPane(ta);
    panel.setLayout(new BorderLayout());
    panel.add(jsp);
    tabbedPane.addTab(text, panel);
  }

  public static void main(String args[]) {
    JFrame f = new JFrame("JTabbedPane Sample");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container content = f.getContentPane();
    JTabbedPane tabbedPane = new JTabbedPane();
    addIt(tabbedPane, "Tab One");
    content.add(tabbedPane, BorderLayout.CENTER);
    f.setSize(300, 200);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}