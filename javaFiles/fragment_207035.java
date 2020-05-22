//superclass
private int rowId;

@Before
public void generateRowId() {
    rowId = SequenceNumberGenerator.nextVal();
}

protected int getRowId() {
    return rowId;
}