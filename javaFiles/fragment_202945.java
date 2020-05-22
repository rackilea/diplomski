Optional<String> result = new TextInputDialog().showAndWait();
if (result.isPresent()) {
    // ok was pressed.
} else {
    // cancel might have been pressed.
}