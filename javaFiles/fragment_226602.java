int count = listView.getChildCount();
boolean allUnchecked = true;
for (int i = 0; i < count; i++) {
    Object child = (Object) listView.getChildAt(i);
    if (child instanceof CheckBox) {
        CheckBox checkBoxChild = (CheckBox) child;
        if (checkBoxChild.isChecked()) {
            allUnchecked = false;   //one is checked, sufficient to say that not all is unchecked
            break;    //get out the for loop
        }
    }
}