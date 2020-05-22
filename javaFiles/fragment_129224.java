private List<String> selectedItems; // +getter +setter.
private List<SelectItem> selectItems; // +getter.

public Bean() {
    // Preset the selected items.
    this.selectedItems = new ArrayList<String>();
    this.selectedItems.add("valueToBePreselected1");
    this.selectedItems.add("valueToBePreselected2");
    // Those values should be exactly the same as one of the SelectItem values.
    // I.e. the Object#equals() must return true for any of them.
}