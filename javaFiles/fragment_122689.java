class NotWorkingRenderer extends BasicComboBoxRenderer {

    private JPanel panel = new JPanel();

    public NotWorkingRenderer() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        //panel.setOpaque(false);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        JLabel c = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        c.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));        
        panel.removeAll();
        panel.add(c);
        panel.revalidate();
        panel.repaint();
        return panel;
    }
}