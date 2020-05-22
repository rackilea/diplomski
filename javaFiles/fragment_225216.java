import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class TestLayout1 {

    public static void main(String[] args) {
        new TestLayout1();
    }

    public TestLayout1() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
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

        public TestPane() {
            setLayout(new GridBagLayout());

            JPanel panelBtns = new JPanel();
            panelBtns.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
            JButton emailBtn = new JButton("a");
            JButton saveBtn = new JButton("b");
            panelBtns.add(emailBtn);
            panelBtns.add(saveBtn);
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 0;
//            c.insets = new Insets(5, 5, 5, 5);
            c.insets= new Insets(2,2,0,2); // panelBtns
            c.weightx = 1;
            c.fill = GridBagConstraints.HORIZONTAL;
//            c.weighty = 1;
            add(panelBtns, c);

            JLabel labelTitle = new JLabel("Title");
            labelTitle.setFont(new Font("calibri", Font.PLAIN, 12));
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 1;
//            c.insets = new Insets(5, 5, 5, 5);
            c.insets=new Insets(0,5,0,5); //titleLabel
            c.weightx = 0.35;
            c.anchor = GridBagConstraints.WEST;
//            c.weighty = 1;
            add(labelTitle, c);

            JTextField textField = new JTextField();
            Border border = BorderFactory.createLineBorder(Color.GRAY);
            textField.setBorder(BorderFactory.createCompoundBorder(border,
                    BorderFactory.createEmptyBorder(2, 2, 2, 2)));
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 2;
//            c.insets = new Insets(5, 5, 5, 5);
            c.insets= new Insets(0,5,0,5); //textField
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 1;
//            c.weighty = 1;
            add(textField, c);

            JLabel bodyLabel = new JLabel("Detail");
            bodyLabel.setFont(new Font("calibri", Font.PLAIN, 12));
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 3;
            c.insets=new Insets(0,5,0,5); //bodyLabel
//            c.insets = new Insets(5, 5, 5, 5);
            c.anchor = GridBagConstraints.WEST;
            c.weightx = 1;
//            c.weighty = 1;
            add(bodyLabel, c);

            JTextArea textArea = new JTextArea();
            Border border1 = BorderFactory.createLineBorder(Color.GRAY);
            textArea.setBorder(BorderFactory.createCompoundBorder(border1,
                    BorderFactory.createEmptyBorder(2, 2, 2, 2)));
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 4;
//            c.insets = new Insets(5, 5, 5, 5);
            c.insets= new Insets(0, 5, 5,5); //textArea
            c.fill = GridBagConstraints.BOTH;
            c.weightx = 1;
            c.weighty = 1;
            add(textArea, c);
        }
    }

}