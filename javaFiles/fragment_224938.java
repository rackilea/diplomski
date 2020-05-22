@SuppressWarnings("serial")
class SomeDialog extends JDialog {
    public SomeDialog(Window window) {
        super(window, "Some Dialog", ModalityType.MODELESS);
        setPreferredSize(new Dimension(300, 200));
        add(new JLabel("Some Dialog", SwingConstants.CENTER));
        pack();
        setLocationByPlatform(true);
    }
}