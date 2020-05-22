import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class ListChooserDemo extends JFrame {
  JTextPane textPane = new JTextPane();
  String lastChoice = null;

  public ListChooserDemo() {
    setTitle("List Chooser Demo");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(new Dimension(500, 500));
    add(new JScrollPane(textPane), BorderLayout.CENTER);
    JPanel buttonPanel = new JPanel(new FlowLayout());
    add(buttonPanel, BorderLayout.SOUTH);
    JButton b = new JButton("Choose it!");
    textPane.setText("Click the button...");
    b.addActionListener(this::doChooseFont);
    buttonPanel.add(b);
  }

  public void doChooseFont(ActionEvent e) {
    // a handy way to get a nontrivial list of choices for a demo
    String[] choices = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

    // Show a list of options with no effort on our part.
    String input = (String) JOptionPane.showInputDialog(
            this,                         // optional reference to frame/window or null
            "Choose a font...",           // prompt displayed over list
            "Font Chooser",               // title
            JOptionPane.QUESTION_MESSAGE, // message style
            null,                         // Use default icon for message style
            choices,                      // array of choices
            lastChoice);                  // initial choice or null
    if (input == null) {
      // Handle case when user canceled, didn't select anything, or hit escape
      textPane.setText(textPane.getText() + "\r\nCanceled!");
    } else {
      // Do stuff that happens when a selection was made
      textPane.setText(textPane.getText() + "\r\nSelected " + input);
      lastChoice = input;
    }
  }

  public static final void main(String[] args) {
    // Run in GUI thread
    SwingUtilities.invokeLater(() -> {
      ListChooserDemo frame = new ListChooserDemo();
      // Center in screen and show
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
      frame.setVisible(true);
    });
  }
}