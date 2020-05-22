public int getSelectedIndex(JSpinner spinner, List<?> values) {
    int index=0;
    for(Object o :values) {
        if(o.equals(spinner.getValue()))
            return index;
        index++;
    }
    return -1;
}
public void setSelectedIndex(JSpinner spinner, List<?> values, int index) {
    spinner.setValue(values.get(index));
}