private String option; // +getter +setter
private List<SelectItem> options; // +getter

public Bean() {
    options = new ArrayList<SelectItem>();

    SelectItemGroup group1 = new SelectItemGroup("Group 1");
    group1.setSelectItems(new SelectItem[] {
        new SelectItem("Group 1 Value 1", "Group 1 Label 1"),
        new SelectItem("Group 1 Value 2", "Group 1 Label 2"),
        new SelectItem("Group 1 Value 3", "Group 1 Label 3")
    });
    options.add(group1);

    SelectItemGroup group2 = new SelectItemGroup("Group 2");
    group2.setSelectItems(new SelectItem[] {
        new SelectItem("Group 2 Value 1", "Group 2 Label 1"),
        new SelectItem("Group 2 Value 2", "Group 2 Label 2"),
        new SelectItem("Group 2 Value 3", "Group 2 Label 3")
    });
    options.add(group2);
}