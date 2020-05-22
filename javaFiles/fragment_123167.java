public class AttachmentsList extends JPanel
{
private List<File>          attachments = null;

private JTable              jt          = null;
private DefaultTableModel   model       = null;
private JScrollPane         scroller    = null;

public AttachmentsList(List<File> attachments)
{
    super();
    this.attachments = attachments;
    setLayout(new GridLayout());

    Vector<Vector> rowData = new Vector<Vector>();

    for (File iterable_element : this.attachments)
    {
        Vector<Object> row = new Vector<Object>();
        row.addElement(iterable_element.getName());
        row.addElement(new JCheckBox());

        rowData.add(row);
    }

    Vector<String> columnNames = new Vector<String>();
    columnNames.add("File");
    columnNames.add("Selected");

    this.jt = new JTable(rowData, columnNames);
    this.jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    this.model = (DefaultTableModel) this.jt.getModel();

    final TableColumnModel columnModel = this.jt.getColumnModel();

    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(1).setPreferredWidth(60);

    this.scroller = new JScrollPane(this.jt);

    add(this.scroller);
}

@Override
public void repaint()
{
    buildTable();
}

protected void buildTable()
{
    if (this.attachments != null)
    {
        Vector<Vector> rowData = new Vector<Vector>();

        for (File currentFile : this.attachments)
        {
            Vector<Object> row = new Vector<Object>();
            row.addElement(currentFile.getName());
            row.addElement(false);

            rowData.add(row);
        }

        this.model.addRow(rowData);
    }
}

public void addFile(File file)
{
    Vector<Object> row = new Vector<Object>();
    row.addElement(file.getName());
    row.addElement(false);

    this.model.addRow(row);
}

public List<File> getAttachments()
{
    return attachments;
}

public void setAttachments(List<File> attachments)
{
    this.attachments = attachments;
}

}