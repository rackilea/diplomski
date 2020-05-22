private ListModelList listData; // of course init and fill it
private Person selectedListBoxItem;

public ListModelList getListData() {
    return listData;
}

public void setSelectedListBoxItem(Person selectedListBoxItem) {
    this.selectedListBoxItem = selectedListBoxItem;
}

public Person getSelectedListBoxItem() {
    return selectedListBoxItem;
}

@Command
@NotifyChange("listData")
public void check() {
    if (selectedListBoxItem != null) {
        if (listData.get(0) != null) {
            System.out.println("added null");
            listData.add(0, null);
        }
    } else {
        if (listData.get(0) == null) {
            System.out.println("removed null");
            listData.remove(0);
        }
    }
}