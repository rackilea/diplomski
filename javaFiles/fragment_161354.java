class FileRenderer extends DefaultListCellRenderer
{
    public Component getListCellRendererComponent(
        JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        File file = (File)value;
        setText( file.getName() );

        return this;
    }
}