public static Boolean test(final List<JComboBox<String>> comboboxList) {
    final List<String> stuff = new ArrayList<>();
    // stuff gets stuffed with stuff here
    comboboxList.forEach(combobox -> {
        combobox.removeAllItems();
        stuff.forEach(combobox::addItem);
    });

   return someBooleanValue; // to compile
}