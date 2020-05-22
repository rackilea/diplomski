public static Boolean test(final List<JComboBox<String>> comboboxList) {
    final List<String> stuff = new ArrayList<>();
    // stuff gets stuffed with stuff here
    comboboxList.forEach((JComboBox<String> combobox) -> {
        combobox.removeAllItems();
        stuff.forEach((contents) -> {
            combobox.addItem(contents);
        });
    });

   return someBooleanValue; // to compile
}