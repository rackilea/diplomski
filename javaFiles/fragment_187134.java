ArrayList<String> listItems = new ArrayList<String>(); // <-- List of Strings

for (int i = 0; i < 18; i++) {
  if (MainActivity.checkBoxes[i].isChecked()) {
      listItems.add(MainActivity.checkBoxes[i].getText()); // Set it to the text of the Checkbox, not the integer index in the loop
  }
}

setListAdapter(new ArrayAdapter<String> (this, R.layout.my_list_layout, listItems));