import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;    
import javax.swing.*;

@SuppressWarnings("serial")
public class MainWindowApp2 extends JPanel {
    private JPanel personPanel = new JPanel(new GridLayout(0, 1, 4, 4));
    private JTextField nameField = new JTextField(10);
    private JTextField idField = new JTextField(10);

    public MainWindowApp2() {
        personPanel.add(new JButton(new PersonAction(new Person("Andres Torres", "AT 001"))));
        personPanel.add(new JButton(new PersonAction(new Person("Alexander Hernandez", "AH 002"))));
        personPanel.add(new JButton(new PersonAction(new Person("Eduardo Ruiz", "ER 003"))));
        personPanel.add(new JButton(new PersonAction(new Person("Jorge Fley", "JF 004"))));
        personPanel.add(new JButton(new PersonAction(new Person("Miguél Gonzales", "MG 005"))));

        JButton addInstallerButton = new JButton(new AbstractAction("Add Installer") {

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String identification = idField.getText();
                Person person = new Person(name, identification);

                JButton personButton = new JButton(new PersonAction(person));
                personPanel.add(personButton);
                personPanel.revalidate();
                personPanel.repaint();
            }
        });

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Name:"));
        topPanel.add(nameField);
        topPanel.add(new JLabel("ID:"));
        topPanel.add(idField);
        topPanel.add(addInstallerButton);

        JPanel personWrapperPanel = new JPanel(new BorderLayout());
        personWrapperPanel.add(personPanel, BorderLayout.PAGE_START);

        JScrollPane scrollPane = new JScrollPane(personWrapperPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        setPreferredSize(new Dimension(600, 600));
        setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        setLayout(new BorderLayout(4, 4));
        add(scrollPane);
        add(topPanel, BorderLayout.PAGE_START);
    }

    private static void createAndShowGui() {
        MainWindowApp2 mainPanel = new MainWindowApp2();

        JFrame frame = new JFrame("MainWindowApp2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}