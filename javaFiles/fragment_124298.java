public int getFreezeColumns() {
    Object currentValue = checkValueBinding("freezeColumns", this.freezeColumns);
    if (currentValue != null) {
        return (Integer)currentValue;
    }
    return 0;
}