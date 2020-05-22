// Find the CheckBoxes within the LinearLayout and search them for the checked ones (= Receivers)
LinearLayout ll = (LinearLayout) findViewById(R.id.who_received);
final int checkBoxCount = ll.getChildCount();
ArrayList<User> users = new ArrayList<User>();
for (int i = 0; i < checkBoxCount; i++) {
    CheckBox currentCheckBox = (CheckBox) ll.getChildAt(i);
    if (currentCheckBox.isChecked()) {
        users.add((User)currentCheckBox.getTag());
    }
}