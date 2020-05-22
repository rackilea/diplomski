// define a boolean property
final BooleanProperty multipleFocusedProperty = new SimpleBooleanProperty();

// add listener to track changes in its value, for debugging purpose only here
multipleFocusedProperty.addListener(new ChangeListener<Boolean>() {
    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        System.out.println("newValue multiple focused = " + newValue);
    }
});

// bind it to other property values
multipleFocusedProperty.bind(search_wrapper.focusedProperty().not().or(nav_button.focusedProperty().not()));

// finally use it as
nav_button.setOnMouseExited(new EventHandler<MouseEvent>()
{
     if(multipleFocusedProperty.getValue())
         hideUsers();
}