import javax.swing.*;
import java.awt.*;

public class ThreeLinesTextArea
{
  public static void main(String[] args)
  {
    JPanel pane = new JPanel();
    // Change to GridBagLayout
    pane.setLayout(new GridBagLayout());
    JTextField url = new JTextField("https:testin.com");
    JTextField username = new JTextField("theDude");

    JTextArea statement = new JTextArea("This statement can becomme very very very long :)");
    statement.setLineWrap(true);
    statement.setWrapStyleWord(true);
    // Use setRows() to make text area have multiple lines
    statement.setRows(3);
    JScrollPane scrollPane = new JScrollPane(statement);

    //This line is removed. scrollPane is added at the end.
    //pane.add(scrollPane);

    pane.add(new JLabel("Enter url: "),
        new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, new Insets(2, 2, 2, 2), 0, 0));
    pane.add(url,
        new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
            GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    pane.add(new JLabel("Enter username: "),
        new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, new Insets(2, 2, 2, 2), 0, 0));
    pane.add(username,
        new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
            GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    pane.add(new JLabel("Enter password: "),
        new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, new Insets(2, 2, 2, 2), 0, 0));
    pane.add(new JPasswordField(15),
        new GridBagConstraints(1, 2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
            GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
    pane.add(new JLabel("Enter statement: "),
        new GridBagConstraints(0, 3, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
            GridBagConstraints.NONE, new Insets(2, 2, 2, 2), 0, 0));
    pane.add(scrollPane,
        new GridBagConstraints(1, 3, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
            GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

    int option = JOptionPane.showConfirmDialog(null, pane, "Fill all the fields",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
  }
}