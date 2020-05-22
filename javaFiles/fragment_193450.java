public void onButtonClick() {
    boolean atLeastOneChecked = false;
    for (int i = 0; i < checkBoxes.size(); i++){
        CheckBox checkBox = checkBoxes.get(i);
        if (checkBox.isChecked()) {
            atLeastOneChecked = true;
            break;
        }
    }
    if (!atLeastOneChecked){
        //make Toast "Hey, you didn't check a box"
    } else {
        //do something based on the checked box.
    }
}