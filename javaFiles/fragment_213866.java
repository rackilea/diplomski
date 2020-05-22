/**
 * Table column layout extended to manage a separate table header.
 */
public class TableColumnLayoutWithSeparateHeader extends TableColumnLayout
{
  /** Header composite */
  private final Composite _headerComposite;
  /** Right margin adjust */
  private final int _rightMargin;


  /**
   * Constructor.
   *
   * @param headerComposite Header composite
   * @param rightMargin Right margin value
   */
  public TableColumnLayoutWithSeparateHeader(final Composite headerComposite, final int rightMargin)
  {
    super();

    _headerComposite = headerComposite;
    _rightMargin = rightMargin;
  }


  /**
   * {@inheritDoc}
   * @see org.eclipse.jface.layout.TableColumnLayout#setColumnWidths(org.eclipse.swt.widgets.Scrollable, int[])
   */
  @Override
  protected void setColumnWidths(final Scrollable tableTree, final int [] widths)
  {
    super.setColumnWidths(tableTree, widths);

    // Update the header composite

    final Control [] children = _headerComposite.getChildren();

    final int size = Math.min(widths.length, children.length);

    for (int index = 0; index < size; ++index) {
       final GridData data = (GridData)children[index].getLayoutData();

       int width = widths[index];
       if (index == (size - 1))
         width -= _rightMargin;

       data.widthHint = width; 
     }

    _headerComposite.layout();
  }
}