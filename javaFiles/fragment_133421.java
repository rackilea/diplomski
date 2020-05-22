/**
 * @contributor https://github.com/vincenzopalazzo
 */
public class PersonalComboBoxUI extends BasicComboBoxUI {

    public static ComponentUI createUI (JComponent c) {
        return new PersonalComboBoxUI ();
    }

    @Override
    public void installUI (JComponent c) {
        super.installUI (c);

        JComboBox<?> comboBox = (JComboBox<?>) c;
        comboBox.setBackground (UIManager.getColor ("ComboBox.background"));
        comboBox.setForeground (UIManager.getColor ("ComboBox.foreground"));
        comboBox.setBorder (UIManager.getBorder ("ComboBox.border"));
        comboBox.setLightWeightPopupEnabled (true);
    }

    @Override
    protected JButton createArrowButton () {
        Icon icon = UIManager.getIcon ("ComboBox.buttonIcon");
        JButton button;
        if (icon != null) {
            button = new JButton (icon);
        }
        else {
            button = new BasicArrowButton (SwingConstants.SOUTH);
        }
        button.setOpaque (true);
        button.setBackground (UIManager.getColor ("ComboBox.buttonBackground"));
        button.setBorder (BorderFactory.createLineBorder(Color.black));
        return button;
    }

    @Override
    protected ListCellRenderer createRenderer() {
        return new MaterialComboBoxRenderer();
    }
}