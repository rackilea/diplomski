public class SkipColumnAction extends WrappedAction
{
    private JTable table;
    private Set columnsToSkip;

    /*
     *  Specify the component and KeyStroke for the Action we want to wrap
     */
    public SkipColumnAction(JTable table, KeyStroke keyStroke, Set columnsToSkip)
    {
        super(table, keyStroke);
        this.table = table;
        this.columnsToSkip = columnsToSkip;
    }

    /*
     *  Provide the custom behaviour of the Action
     */
    public void actionPerformed(ActionEvent e)
    {
        TableColumnModel tcm = table.getColumnModel();
        String header;

        do
        {
            invokeOriginalAction( e );

            int column = table.getSelectedColumn();
            header = tcm.getColumn( column ).getHeaderValue().toString();
        }
        while (columnsToSkip.contains( header ));
    }
}