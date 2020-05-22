private String selectedItem; // +getter +setter
private List<SelectItem> selectItems; // +getter

public Bean() {
    selectItems = new ArrayList<SelectItem>();
    selectItems.add(new SelectItem("value1", "label1"));
    selectItems.add(new SelectItem("value2", "label2"));
    selectItems.add(new SelectItem("value3", "label3"));
    // You can also use SelectItem[] or Map<Object, String> instead.
}

public String submit() {
    // Selected item is already set by JSF. The below line just shows it.
    System.out.println(selectedItem); // value1, value2 or value3
    return null;
}