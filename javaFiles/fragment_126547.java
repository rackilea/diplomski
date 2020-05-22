private static class CustomComboBoxRenderer extends DefaultListCellRenderer
{
    private final ListCellRenderer backend;

    public CustomComboBoxRenderer(ListCellRenderer backend)
    {
        this.backend = backend;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        Component component = backend.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if(component instanceof JLabel == false)
            component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        JLabel label = (JLabel)component;
        label.setIcon(Icons.COMPONENT);
        return label;
    }
}