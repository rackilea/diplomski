class FooRenderer extends BasicComboBoxRenderer
{
    public Component getListCellRendererComponent(
        JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof Foo)
        {
            Foo foo = (Foo)value;
            setText( foo.getDescription() );
        }

        return this;
    }
}