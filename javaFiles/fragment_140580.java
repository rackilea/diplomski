@Override
public void setValueAt(Object value, int row, int col)
{
    super.setValueAt(value, row, col);
    tableBinding.unbind();
    tableBinding.bind();
    revalidate();
}