homeCheckBox.setOnCheckedChangedListener(buttonView, isChecked -> {
    if(buttonView.isPressed()){
       //user pressed the button. (handle user clicks)
    } else {
       //the program toggled the checkbox (do nothing)
    }
});