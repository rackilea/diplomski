import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

public class TestingGround {

    private static final String[] PRODUCT_LINE_LIST = {"-", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};

    private final List<JComboBox<String>> projectLineComboBoxList;

    private final List<String> userOptionList;

    private int countAddClicks;

    public TestingGround() {
        JFrame frame = new JFrame("Testing ground area");

        centerToScreen(frame);

        JPopupMenu menu = new JPopupMenu();
        JMenuItem addRow = new JMenuItem("Add ComboBox");
        JMenuItem removeRow = new JMenuItem("Remove ComboBox");
        JPanel panel = new JPanel();
        JPanel mainGridPanel = new JPanel();

        mainGridPanel.setLayout(new GridLayout(0, 2));
        mainGridPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        panel.add(mainGridPanel);

        userOptionList = new ArrayList<>();
        projectLineComboBoxList = new ArrayList<>();

        JButton button = new JButton("save state");
        countAddClicks = 0;
        panel.add(button);

        // ACTION LISTENERS
        addRow.addActionListener(new ActionListener() { // Right click to add JComboBoxes to the screen
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Initial click is: " + countAddClicks);

                JComboBox<String> productLineBox = new JComboBox<>(PRODUCT_LINE_LIST); // add a new JComboBox
                projectLineComboBoxList.add(countAddClicks, productLineBox); // add this JComboBox to the JComboBox Array List

                countAddClicks++;
                System.out.println("After click is: " + countAddClicks);

                mainGridPanel.add(productLineBox);
                mainGridPanel.repaint();
                mainGridPanel.revalidate();

            }
        });

        // Problem is right here!
        removeRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                countAddClicks--;
                System.out.println("After removal click is: " + countAddClicks);
                // delete from the Array of JComboBoxes
                JComboBox<String> productLineBox = projectLineComboBoxList.remove(projectLineComboBoxList.size() - 1);
                // userOptionList.remove(userOptionList.size() - 1);

                mainGridPanel.remove(productLineBox); // THIS action removes only the last ComboBox from the screen, and does not "see" the
                                                      // other ones that I want to remove. It should remove one by one from the screen.
                mainGridPanel.revalidate();
                mainGridPanel.repaint();

            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                userOptionList.clear();

                for (int i = 0; i < projectLineComboBoxList.size(); i++) {
                    JComboBox<String> tempBoxxx = projectLineComboBoxList.get(i);
                    String tzz = tempBoxxx.getSelectedItem().toString();
                    userOptionList.add(tzz); // Add the text to the String Array List
                }

                System.out.println();
                System.out.println("The length of the JComboBox Array is: " + projectLineComboBoxList.size());
                System.out.println("The content of the String array is: " + userOptionList);
                System.out.println("The size of the String array is: " + userOptionList.size());
                System.out.println();

            }

        });

        ((JComponent) frame.getContentPane()).setComponentPopupMenu(menu);

        menu.add(addRow);
        menu.add(removeRow);

        frame.add(panel);

        frame.setVisible(true);
    }

    private void centerToScreen(JFrame frame) {
        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("A Popup Menu");
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TestingGround::new);
    }
}