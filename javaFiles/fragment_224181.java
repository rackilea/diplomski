public class LabelDecoratorProvider extends DecoratingStyledCellLabelProvider {

    public LabelDecoratorProvider(IStyledLabelProvider labelProvider,  
        ILabelDecorator decorator, IDecorationContext decorationContext) {
        super(labelProvider, decorator, decorationContext);
    }

    @Override
    public void update(ViewerCell cell) {
        super.update(cell);
        if (TableViewer.class.isInstance(getViewer())) {
            TableViewer tableViewer = ((TableViewer)getViewer());
            Table table = tableViewer.getTable();
            for (int i = 0, n = table.getColumnCount(); i < n; i++)
                table.getColumn(i).pack();
        }
    }
}