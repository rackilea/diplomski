ArrayList<Integer> listItems = new ArrayList<Integer>(); // <-- List of Integers

for (int i = 0; i < 18; i++) {
  if (MainActivity.checkBoxes[i].isChecked()) {
      listItems.add(i); // <-- You're adding an integer to the List
  }
}