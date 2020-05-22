import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SearchTextFile {

    public static void main(String[] args) {
        new SearchTextFile();
    }

    public SearchTextFile() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Bible Search");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JTextField findText;
        private JButton search;
        private DefaultListModel<String> model;
        private JList list;

        private String searchPhrase;

        public TestPane() {
            setLayout(new BorderLayout());
            JPanel searchPane = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(2, 2, 2, 2);
            searchPane.add(new JLabel("Find: "), gbc);
            gbc.gridx++;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1;
            findText = new JTextField(20);
            searchPane.add(findText, gbc);

            gbc.gridx++;
            gbc.fill = GridBagConstraints.NONE;
            gbc.weightx = 0;
            search = new JButton("Search");
            searchPane.add(search, gbc);

            add(searchPane, BorderLayout.NORTH);

            model = new DefaultListModel<>();
            list = new JList(model);
            list.setCellRenderer(new HighlightListCellRenderer());
            add(new JScrollPane(list));

            ActionHandler handler = new ActionHandler();

            search.addActionListener(handler);
            findText.addActionListener(handler);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/Script.txt")))) {

                String text = null;
                while ((text = reader.readLine()) != null) {
                    model.addElement(text);
                }

            } catch (IOException exp) {

                exp.printStackTrace();

            }
        }

        public class ActionHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                searchPhrase = findText.getText();
                if (searchPhrase != null && searchPhrase.trim().length() == 0) {
                    searchPhrase = null;
                }
                list.repaint();
//              model.removeAllElements();
////                    BufferedReader reader = null;
//
//              String searchText = findText.getText();
//              try (BufferedReader reader = new BufferedReader(new FileReader(new File("bible.txt")))) {
//
//                  String text = null;
//                  while ((text = reader.readLine()) != null) {
//
//                      if (text.contains(searchText)) {
//
//                          model.addElement(text);
//
//                      }
//
//                  }
//
//              } catch (IOException exp) {
//
//                  exp.printStackTrace();
//                  JOptionPane.showMessageDialog(TestPane.this, "Something Went Wrong", "Error", JOptionPane.ERROR_MESSAGE);
//
//              }
            }
        }

        public class HighlightListCellRenderer extends DefaultListCellRenderer {

            public final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof String && searchPhrase != null) {
                    String text = (String) value;
                    if (text.contains(searchPhrase)) {
                        text = text.replace(" ", "&nbsp;");
                        value = "<html>" + text.replace(searchPhrase, "<font color=#ffff00>" + searchPhrase + "</font>") + "</html>";
                    }
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
            }

        }
    }
}