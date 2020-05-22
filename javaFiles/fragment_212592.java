enum Column {
    CATEGORY(0), 
    COUNT(1);

    private final int index;

    Column(int index) {
        this.index = index;
    }

    public int getIntValue(Object[] row) {
        return (int)row[index]);
    }

    public String getStringValue(Object[] row) {
        return (String)row[index];
    }
}