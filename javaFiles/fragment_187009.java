class TableListCellRenderer
implements ListCellRenderer<String[]>
{
    @Override
    public Component getListCellRendererComponent(JList<? extends String[]> list,
                                               String[] value,
                                               int index,
                                               boolean isSelected,
                                               boolean cellHasFocus) {
        JPanel ret = new JPanel(new GridLayout(1,2));
        ret.add(new JLabel(value[0]));
        ret.add(new JLabel(value[1]));
        return ret;
    }
}