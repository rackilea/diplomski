public class SomeTable<T extends BaseTableEntry> extends BaseTable<T> {
    public SomeTable(int rows, int cols)
    {
        super(rows, cols, (Class<T>)SomeTableEntry.class);
    }
}