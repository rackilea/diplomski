class SelectAll extends TextAction
{
    public SelectAll()
    {
        super("Select All");
    }

    public void actionPerformed(ActionEvent e)
    {
        JTextComponent component = getFocusedComponent();
        component.selectAll();
    }
}