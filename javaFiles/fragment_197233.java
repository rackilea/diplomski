hourColumn.setFieldUpdater(new FieldUpdater<EffortCost, String>() {
@Override
public void update(int index, EffortCost object, String value) {
    // do something when value changes
    // return NumberFormat.getFormat("0.00").format(object.getHours());
}
});