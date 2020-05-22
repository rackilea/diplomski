import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Student extends JPanel {

    private static final long serialVersionUID = 8923497527096438302L;

    private JLabel picture;
    private JLabel lblStudentID = new JLabel("Student ID:");
    private JLabel lblName = new JLabel("Name:");

    TextField txtStudentID = new TextField();
    TextField txtName = new TextField();

    public Student() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setBackground(Color.WHITE);
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        formPanel.setOpaque(false);

        picture = new JLabel(createImageIcon("images/student.jpg"));
        picture.setPreferredSize(new Dimension(100, 100));
        picture.setBorder(BorderFactory.createLineBorder(Color.black));

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 0;
        formPanel.add(picture, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        formPanel.add(lblName, gbc);
        gbc.gridy = 1;
        gbc.weightx = 1;
        formPanel.add(txtName, gbc);
        gbc.weightx = 0;
        gbc.gridy = 2;
        formPanel.add(lblStudentID, gbc);
        gbc.gridy = 2;
        formPanel.add(txtStudentID, gbc);

        add(formPanel, BorderLayout.PAGE_START);
    }

    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Student");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 300);
        // Display the window.

        new Student().setBackground(Color.white);
        frame.setContentPane(new Student());
        frame.setVisible(true);
    }

    protected static ImageIcon createImageIcon(String path) {
        URL imgURL = Student.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}