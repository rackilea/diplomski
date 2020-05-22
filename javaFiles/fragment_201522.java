for (int i = 0; i < checked.size(); i++) {
    // Item position in adapter
    int position = checked.keyAt(i);
    // Add sport if it is checked i.e.) == TRUE!
    if (checked.valueAt(i))
        selectedItems.add(extractStudentID(adapter.getItem(position)));
}