public void minYearChanged(ValueChangeEvent event) {
    int newValue = new Integer(event.getNewValue().toString());
    this.maxYearValues = fillYearValues(newValue, getPresentYear());
}

public void maxYearChanged(ValueChangeEvent event) {
    int newValue = new Integer(event.getNewValue().toString());
    this.minYearValues = fillYearValues(MIN_YEAR, newValue);
}