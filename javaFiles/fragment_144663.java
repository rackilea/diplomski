import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JRadioLabelButton extends JPanel {

    private final JRadioButton radioButton;
    private final JLabel label;

    public JRadioLabelButton(final String text) {

        radioButton = new JRadioButton();
        label = new JLabel(text);

        add(radioButton);
        add(label);
    }

    public static void main(final String[] args) {

        JFrame fr = new JFrame();
        JRadioLabelButton myRadioLabelButton = new JRadioLabelButton("some text");

        JLabel label = myRadioLabelButton.getLabel();
        // do things with the label
        JRadioButton radioButton = myRadioLabelButton.getRadioButton();
        // do things with the radio button

        fr.getContentPane().add(myRadioLabelButton);
        fr.pack();
        fr.setVisible(true);
    }

    public JRadioButton getRadioButton() {
        return radioButton;
    }

    public JLabel getLabel() {
        return label;
    }

}