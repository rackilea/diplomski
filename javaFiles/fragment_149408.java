import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Test {
    public JButton button;

    private static final Insets normalInsets = new Insets(10,10,0,10);
    private static final Insets finalInsets = new Insets(10,10,10,10);

    public final static int NUM_OF_FIELDS = 3;

    private static JTextField[] markTextFields = new JTextField[NUM_OF_FIELDS];
    private static JTextField[] weightTextFields = new JTextField[NUM_OF_FIELDS];

    private static JPanel createMainPanel() {
        GridBagConstraints gbc = new GridBagConstraints();

        //Adding the JPanels. Panel for instructions
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        int gridy = 1;

        //JLabel for the Instructions
        JTextArea instructionTextArea = new JTextArea(5, 30);
        instructionTextArea.setEditable(false);
        instructionTextArea.setLineWrap(true);
        instructionTextArea.setWrapStyleWord(true);

        JScrollPane instructionScrollPane = new JScrollPane(instructionTextArea);
        addComponent(panel, instructionScrollPane, 0, gridy++, 3, 1, finalInsets, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        //JLabels for Assignment
        JLabel label1 = new JLabel("Assignment");
        label1.setHorizontalAlignment(JLabel.CENTER);
        addComponent(panel, label1, 0, gridy, 1, 1, finalInsets,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);

        //JLabel for Mark
        JLabel label2 = new JLabel("Mark");
        label2.setHorizontalAlignment(JLabel.CENTER);
        addComponent(panel, label2, 1, gridy, 1, 1, finalInsets, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        //JLabel for Weight.
        JLabel label3 = new JLabel("Weight");
        label3.setHorizontalAlignment(JLabel.CENTER);
        addComponent(panel, label3, 2, gridy++, 1, 1, finalInsets, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);

        //JLabel Number for the number list of assignments at the side.
        gbc.gridy = 3;

        for (int i = 1; i <= 3; i++) {
            String kok = String.valueOf(i);
            JLabel number = new JLabel(kok);
            number.setHorizontalAlignment(JLabel.CENTER);
            addComponent(panel, number, 0, gbc.gridy++, 1, 1, normalInsets, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        }
        gbc.gridy = 3;

        //JTextfield for Mark
        for (int i = 0; i < NUM_OF_FIELDS; i++) {
            JTextField mark = new JTextField(20);
            markTextFields[i] = mark;
            mark.setHorizontalAlignment(JLabel.CENTER);
            addComponent(panel, mark, 1, gbc.gridy++, 1, 1, normalInsets, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        }
        gbc.gridy = 3;

        //JTextfield for Weight       
        for (int i = 0; i < NUM_OF_FIELDS; i++) {    
            JTextField weight = new JTextField(20);
            weightTextFields[i] = weight;
            weight.setHorizontalAlignment(JLabel.CENTER);   
            addComponent(panel, weight, 2, gbc.gridy++, 1, 1, normalInsets, GridBagConstraints.CENTER,GridBagConstraints.NONE);
        }

        JButton button = new JButton("Enter");
        button.setHorizontalAlignment(SwingConstants.CENTER);
        addComponent(panel, button, 3, gbc.gridy++, 1, 1, normalInsets, GridBagConstraints.CENTER,GridBagConstraints.CENTER);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double finalScore = 0;
                for (int i = 0; i < NUM_OF_FIELDS; i++) {
                    double weight = Double.parseDouble(weightTextFields[i].getText());
                    double mark = Double.parseDouble(markTextFields[i].getText());
                    finalScore += weight / 100 * mark;
                }
                JOptionPane.showMessageDialog(null, "Final score: " + finalScore, "Final Score", JOptionPane.OK_OPTION);
            }
        });
        return panel;
    }

    private static void addComponent(Container container, Component component, int gridx, int gridy, int gridwidth, int gridheight, Insets insets, int anchor, int fill) {
        GridBagConstraints grid = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0D, 1.0D, anchor, fill, insets, 0, 0);
        container.add(component, grid);
    }

    public static void main(String[] args) {    
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(createMainPanel());
        frame.pack();
        frame.setVisible(true);
        new Test();
    }
}