JComponent container = formEnvironment.getComponentTuple(component).getCenterComponent();
for (int i = 0; i < container.getComponentCount(); i++) {
    JComponent c = (JComponent)container.getComponent(i);
    if (c instanceof JLabel) {
        c.setFont(c.getFont().deriveFont(java.awt.Font.BOLD));
    }
}