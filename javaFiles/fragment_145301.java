/* This method displays the CheckBoxes with the user names to the R.layout.new_payment_screen layout file */
private void createCheckboxes(SharedFlat flat) {
    // Find the layout and create a Checkbox Array to store all users
    LinearLayout ll = (LinearLayout) findViewById(R.id.who_received);
    final CheckBox[] checkBoxes = new CheckBox[flat.getNumberOfUsers()];
    // Create a new Checkbox for each user and set the users name to it
    for (int i = 0; i < checkBoxes.length; i++) {
        // create new checkboxes
        checkBoxes[i] = new CheckBox(this);
        // add checkboxes to the layout
        ll.addView(checkBoxes[i]);
        // set text of the CheckBox to be userName of current User object
        checkBoxes[i].setText(flat.getSpecificUserName(i));
        // set the ID to be the userID of the corresponding User
        checkBoxes[i].setId(flat.getSpecificUserID(i));
        checkBoxes[i].setTag(flat.getUser(i));
    }
}