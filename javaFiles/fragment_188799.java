CheckBox checkBox = new CheckBox();
checkBox.indeterminateProperty().set(true);
checkBox.setAllowIndeterminate(false);

checkBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
    if(newVal)
        System.out.println("Checked");
    else
        System.out.println("Unchecked");
});