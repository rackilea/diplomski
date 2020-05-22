public class CustomToolBar extends JToolBar {

    public CustomToolBar() {
        setBackground(Color.RED);
    }

    protected void addImpl(Component comp, Object constraints, int index) {
        super.addImpl(comp, constraints, index);
        if (comp instanceof JButton) {
            ((JButton) comp).setContentAreaFilled(false);
        }
    }

}