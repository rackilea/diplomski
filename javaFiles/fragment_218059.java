final ToggleGroup group = new ToggleGroup();

RadioButton male = new RadioButton("Male");
male.setToggleGroup(group);
male.setUserData("M");

RadioButton female = new RadioButton("Female");
female.setToggleGroup(group);
female.setUserData("F");

group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
  public void changed(ObservableValue<? extends Toggle> ov,
      Toggle old_toggle, Toggle new_toggle) {
    if (group.getSelectedToggle() != null) {
      System.out.println(group.getSelectedToggle().getUserData().toString());
    }
  }
});