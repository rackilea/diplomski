public class SwingUtils {

public static JButton createMyButton (String iconPath, String toolTip) {
    final JButton b = new JButton (new ImageIcon(SwingUtils.class.getResource(iconPath)));
    final Border raisedBevelBorder = BorderFactory.createRaisedBevelBorder();
    final Insets insets = raisedBevelBorder.getBorderInsets(b);
    final EmptyBorder emptyBorder = new EmptyBorder(insets);
    b.setBorder(emptyBorder);
    b.setFocusPainted(false);
    b.setOpaque(false);
    b.setContentAreaFilled(false);
    b.setToolTipText(toolTip);
    b.getModel().addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isRollover()) {
                b.setBorder(raisedBevelBorder);
            } else {
                b.setBorder(emptyBorder);
            }
        }
    });
    return b;
}

}