class MarriedEditingSupport extends EditingSupport
{
  private final CheckboxCellEditor _editor;

  MarriedEditingSupport(TableViewer viewer)
  {
    super(viewer);

    _editor = new CheckboxCellEditor(viewer.getTable());
  }

  @Override
  protected CellEditor getCellEditor(Object element)
  {
    return _editor;
  }

  @Override
  protected boolean canEdit(Object element)
  {
    return true;
  }

  @Override
  protected Object getValue(Object element)
  {
    return Boolean.valueOf(((Person)element).isMarried());
  }

  @Override
  protected void setValue(Object element, Object value)
  {
    ((Person)element).setMarried(((Boolean)value).booleanValue());

    getViewer().update(element, null);
  }
}