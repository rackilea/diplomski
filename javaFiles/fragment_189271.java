import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class QuestionTwo {

    public static void main(String[] args) {
        CheckRadio two = new CheckRadio("Font Chooser");
        two.init();

    }
}

@SuppressWarnings("serial")
class CheckRadio extends JFrame {

    JButton okButton;
    JCheckBox bold;
    JCheckBox italic;
    JRadioButton ti;
    JRadioButton he;
    JRadioButton co;
    ButtonGroup group;
    JTextField tf;

    public CheckRadio(String s) {
        super(s);
    }

    public void init() {

        setFont(new Font("Times", Font.PLAIN, 12));

        JPanel check = new JPanel();
        check.setLayout(new GridLayout(2, 1));

        bold = new JCheckBox("Bold");
        bold.setFont(getFont().deriveFont(Font.BOLD));
        italic = new JCheckBox("Italic");
        italic.setFont(getFont().deriveFont(Font.ITALIC));

        check.add(bold);
        check.add(italic);

        JPanel radio = new JPanel();
        radio.setLayout(new GridLayout(3, 1));
        group = new ButtonGroup();

        ti = new JRadioButton("Times");
        he = new JRadioButton("Heltivica");
        co = new JRadioButton("Courier");
        ti.setFont(getFont().deriveFont(Font.TRUETYPE_FONT, 15));
        he.setFont(getFont().deriveFont(Font.TRUETYPE_FONT, 16));
        co.setFont(getFont().deriveFont(Font.TRUETYPE_FONT, 17));
        group.add(ti);
        group.add(he);
        group.add(co);

        radio.add(ti);
        radio.add(he);
        radio.add(co);

        JLabel textBox = new JLabel();
        textBox.setLayout(new GridLayout(3, 1));

        tf = new JTextField(10);

        textBox.add(new JLabel(""));
        textBox.add(tf);
        textBox.add(new JLabel(""));

        JLabel okLabel = new JLabel();
        okLabel.setLayout(new GridLayout(3, 1));

        okButton = new JButton("OK");

        okLabel.add(new JLabel(""));
        okLabel.add(okButton);
        okLabel.add(new JLabel(""));

        Container panel = this.getContentPane();
        panel.setLayout(new GridLayout(1, 4));
        panel.add(check);
        panel.add(radio);
        panel.add(textBox);
        panel.add(okLabel);

        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                updateFont();

            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public void updateFont() {
        int derivedFont = Font.TRUETYPE_FONT;
        String text = "";
        int font = 0;
        if (italic.isSelected())
            derivedFont += Font.ITALIC;
        if (bold.isSelected())
            derivedFont += Font.BOLD;
        if (ti.isSelected()){
            font = 15;
            text = "times";
        } else if (he.isSelected()){
            font = 16;
            text = "helvtica";
        } else if (co.isSelected()){
            font = 18;
            text = "courrier";
        }

        tf.setFont(getFont().deriveFont(derivedFont, font));
        tf.setText(text);

    }
}